package md.orange.preorderback.service;


import md.orange.preorderback.dto.request.BookingDTO;

public interface BookingService {
    void validateAndBook(BookingDTO bookingdto);
}
