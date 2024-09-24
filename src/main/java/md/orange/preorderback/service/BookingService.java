package md.orange.preorderback.service;


import md.orange.preorderback.dto.request.BookingDTO;
import md.orange.preorderback.enums.Status;

import java.util.List;

public interface BookingService {
    List<BookingDTO> getBookings(Long locationId);

    void validateAndBook(BookingDTO bookingdto);

    void finalizeBooking(Long bookingId, Status status);
}
