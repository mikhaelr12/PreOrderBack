package md.orange.preorderback.service;


import md.orange.preorderback.dto.request.BookingDTO;
import md.orange.preorderback.enums.Status;

public interface BookingService {
    void validateAndBook(BookingDTO bookingdto);

    void finalizeBooking(Long bookingId, Status status);
}
