package md.orange.preorderback.service;


import md.orange.preorderback.dto.request.BookingDTO;
import md.orange.preorderback.entity.Booking;

public interface BookingService {
    void addBooking(BookingDTO bookingdto);
}
