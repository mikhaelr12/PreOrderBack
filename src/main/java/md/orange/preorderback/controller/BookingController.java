package md.orange.preorderback.controller;

import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.dto.request.BookingDTO;
import md.orange.preorderback.exception.BookingException;
import md.orange.preorderback.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PutMapping
    public ResponseEntity<String> validateAndBook(@RequestBody BookingDTO bookingDTO) {
        try {
            bookingService.validateAndBook(bookingDTO);
            return ResponseEntity.ok("Booking created successfully.");
        } catch (BookingException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().body("Service currently unavailable, please try a little later!");
        }
    }
}
