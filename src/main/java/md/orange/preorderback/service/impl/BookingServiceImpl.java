package md.orange.preorderback.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.dto.LocationDTO;
import md.orange.preorderback.dto.request.BookingDTO;
import md.orange.preorderback.entity.Booking;
import md.orange.preorderback.entity.Restaurant;
import md.orange.preorderback.enums.Status;
import md.orange.preorderback.exception.BookingException;
import md.orange.preorderback.repository.BookingRepository;
import md.orange.preorderback.service.BookingService;
import md.orange.preorderback.service.CustomMap;
import md.orange.preorderback.service.MailService;
import md.orange.preorderback.service.RestaurantResourceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private static final String SUBJECT = "Confirmarea comenenzii";
    private final BookingRepository bookingRepository;
    private final RestaurantResourceService restaurantResourceService;
    private final MailService mailService;

    @Override
    public List<BookingDTO> getBookings(Long locationId) {
        CustomMap<List<Long>, String> mapFromStringToLongList = (items) -> {
            List<String> arrayToList = List.of(
                    items.replace("[", "").replace("]", "").split(",")
            );
            List<Long> arrayToLongList = new ArrayList<>();
            for (String s : arrayToList) {
                arrayToLongList.add(Long.parseLong(s.trim()));
            }
            return arrayToLongList;
        };

        return bookingRepository.findAllByLocationId(locationId).stream()
                .map(b -> BookingDTO.builder()
                        .id(b.getId())
                        .name(b.getName())
                        .phoneNumber(b.getPhoneNumber())
                        .noPeople(b.getNoPeople())
                        .preferences(b.getPreferences())
                        .locationId(b.getLocationId())
                        .tableId(b.getTableId())
                        .itemIds(mapFromStringToLongList.map(b.getItems()))
                        .mail(b.getMail())
                        .status(b.getBookingStatus())
                        .build()
                ).toList();
    }

    @Override
    @Transactional
    public void validateAndBook(BookingDTO bookingdto) {
        if (bookingdto.getTableId() != null && !restaurantResourceService.isFreeTable(bookingdto.getTableId())) {
            throw new BookingException("Table is not free, change it or try again later!");
        } else {
            restaurantResourceService.updateTableFreeStatus(bookingdto.getTableId(), false);
        }

        Booking booking = bookingRepository.save(
                Booking.builder()
                        .tableId(bookingdto.getTableId())
                        .locationId(bookingdto.getLocationId())
                        .bookingStatus(Status.IN_PROGRESS)
                        .noPeople(bookingdto.getNoPeople())
                        .preferences(bookingdto.getPreferences())
                        .finalPrice(restaurantResourceService.calcAndGetPrice(bookingdto.getItemIds()))
                        .name(bookingdto.getName())
                        .phoneNumber(bookingdto.getPhoneNumber())
                        .mail(bookingdto.getMail())
                        .items(bookingdto.getItemIds().toString())
                        .build()
        );

        new Thread(() -> sendEmail(bookingdto, booking)).start();
    }

    @Override
    @Transactional
    public void finalizeBooking(Long bookingId, Status status) {
        log.info("Finalizing booking: {} with status {}", bookingId, status);
        Optional<Booking> booking = bookingRepository.findById(bookingId);

        if (booking.isPresent()) {
            booking.get().setBookingStatus(status);
            bookingRepository.save(booking.get());
            restaurantResourceService.updateTableFreeStatus(booking.get().getTableId(), true);
        }
    }

    private void sendEmail(BookingDTO bookingdto, Booking booking) {
        Optional<Restaurant> restaurant =
                restaurantResourceService.findRestaurantByLocationId(bookingdto.getLocationId());

        try {
            String text = "Detalii comanda: \n";
            text += "Data: " + bookingdto.getBookingDate() + "\n";
            if (bookingdto.getNoPeople() > 0) {
                text += "Nr. de persoane: " + bookingdto.getNoPeople() + "\n";
            }
            if (restaurant.isPresent()) {
                text += "Restaurant: " + restaurant.get().getRestaurantName() + "\n";

                List<LocationDTO> locationDTOS =
                        restaurantResourceService.getLocationsByRestaurantId(restaurant.get().getId());

                LocationDTO locationDTO = locationDTOS.stream()
                        .filter(l -> Objects.equals(l.getId(), booking.getLocationId()))
                        .findFirst()
                        .orElse(null);

                if (locationDTO != null) {
                    text += "Adresa: " + locationDTO.getAddress() + "\n";
                }
            }

            text += "Produse: \n";
            text += restaurantResourceService.getItemsToText(bookingdto.getItemIds());
            text += "Total: " + booking.getFinalPrice() + " MDL\n";
            text += "Multumim pentru comanda!";
            mailService.sendMail(bookingdto.getMail(), SUBJECT, text);
        } catch (Exception e) {
            log.error("Failed sent mail, caused by: {}", e.getMessage());
        }
    }
}