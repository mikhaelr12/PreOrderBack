package md.orange.preorderback.controller;

import io.swagger.v3.oas.annotations.Operation;
import md.orange.preorderback.dto.request.BookingDTO;
import md.orange.preorderback.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            bookingService.addBooking(bookingDTO);
            return ResponseEntity.ok("Booking created successfully.");
        } catch (Exception e) {
            // Log the error for debugging purposes
            return ResponseEntity.badRequest().body("Failed to create booking: " + e.getMessage());
        }
    }
}
