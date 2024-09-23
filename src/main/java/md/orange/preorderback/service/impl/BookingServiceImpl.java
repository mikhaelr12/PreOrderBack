package md.orange.preorderback.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.dto.request.BookingDTO;
import md.orange.preorderback.entity.Booking;
import md.orange.preorderback.entity.Table;
import md.orange.preorderback.enums.Status;
import md.orange.preorderback.repository.BookingRepository;
import md.orange.preorderback.repository.TableRepository;
import md.orange.preorderback.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final TableRepository tableRepository;


    @Override
    public void addBooking(BookingDTO bookingDTO) {

        List<Booking> locationBookings = bookingRepository.getAllBookingsByLocationId(bookingDTO.getLocationId());
        List<Table> tables = tableRepository.getTablesByLocationId(bookingDTO.getLocationId());

        long bufferMinutes = 60;

        LocalTime startBookingTime = LocalTime.of(8, 0); // 8 AM
        LocalTime endBookingTime = LocalTime.of(21, 0); // 11 PM

        LocalTime requestedTime = bookingDTO.getOrderTime().toLocalTime();
        if (requestedTime.isBefore(startBookingTime) || requestedTime.isAfter(endBookingTime)) {
            throw new RuntimeException("Bookings are only allowed between 08:00 and 21:00.");
        }

        List<Table> availableTables = tables.stream()
                .filter(t -> locationBookings.stream()
                        .noneMatch(b -> b.getTableId().equals(t.getId()) &&
                                (b.getOrderTime()
                                        .isBefore(bookingDTO.getOrderTime().plusMinutes(bufferMinutes)) &&
                                        b.getOrderTime()
                                                .plusMinutes(bufferMinutes)
                                                .isAfter(bookingDTO.getOrderTime())))
                ).toList();

        if (!availableTables.isEmpty()) {
            Table selectedTable = availableTables.get(0);

            // Create and save the booking
            Booking makeBooking = new Booking();
            makeBooking.setTableId(selectedTable.getId());
            makeBooking.setLocationId(bookingDTO.getLocationId());
            makeBooking.setFinalPrice(bookingDTO.getFinalPrice());
            makeBooking.setNoPeople(bookingDTO.getNoPeople());
            makeBooking.setPreferences(bookingDTO.getPreferences());
            makeBooking.setOrderTime(bookingDTO.getOrderTime());
            makeBooking.setPhoneNumber(bookingDTO.getPhoneNumber());
            makeBooking.setName(bookingDTO.getName());

            bookingRepository.save(makeBooking);
        } else {
            throw new RuntimeException("No available tables for the selected location and time.");
        }
    }
}