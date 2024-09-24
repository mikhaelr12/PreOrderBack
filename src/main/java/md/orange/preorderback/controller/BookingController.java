package md.orange.preorderback.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.dto.request.BookingDTO;
import md.orange.preorderback.enums.Status;
import md.orange.preorderback.exception.BookingException;
import md.orange.preorderback.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/{localtionId}")
    public ResponseEntity<List<BookingDTO>> getBookings(@PathVariable Long localtionId) {
        return ResponseEntity.ok(bookingService.getBookings(localtionId));
    }

    @PostMapping
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

    @PutMapping("/finalize/{bookingId}/{status}")
    public ResponseEntity<?> finalizeBooking(@PathVariable Long bookingId, @PathVariable Status status) {
        bookingService.finalizeBooking(bookingId, status);
        return ResponseEntity.accepted().build();
    }
}
