package md.orange.preorderback.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.dto.request.BookingDTO;
import md.orange.preorderback.entity.Booking;
import md.orange.preorderback.enums.Status;
import md.orange.preorderback.exception.BookingException;
import md.orange.preorderback.repository.BookingRepository;
import md.orange.preorderback.service.BookingService;
import md.orange.preorderback.service.MailService;
import md.orange.preorderback.service.RestaurantResourceService;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private static final String SUBJECT = "Booking confirmation";
    private final BookingRepository bookingRepository;
    private final RestaurantResourceService restaurantResourceService;
    private final MailService mailService;

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

        try {
            String text = "Confirmarea comenzii: \n";
            text += restaurantResourceService.getItemsToText(bookingdto.getItemIds());
            text += "Total: " + booking.getFinalPrice() + " MDL";
            mailService.sendMail(bookingdto.getMail(), SUBJECT, text);
        } catch (Exception e) {
            log.error("Failed sent mail, caused by: {}", e.getMessage());
        }
    }
}