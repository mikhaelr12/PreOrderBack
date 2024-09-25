package md.orange.preorderback.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping("/{locationId}")
    @Operation(summary = "Get bookings by locationId", description = "Returns all the bookings based on a locationId")
    public ResponseEntity<List<BookingDTO>> getBookings(@PathVariable Long locationId) {
        return ResponseEntity.ok(bookingService.getBookings(locationId));
    }

    @PostMapping
    @Operation(summary = "Validate and make a booking", description = "Make the booking and return a message," +
            " id and status are unnecessary, if the booking is pick up, tableId : null")
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
    @Operation(summary = "Find booking by bookingId and change status", description = "Finds necessary booking by" +
            " bookingId and change its status")
    public ResponseEntity<?> finalizeBooking(@PathVariable Long bookingId, @PathVariable Status status) {
        bookingService.finalizeBooking(bookingId, status);
        return ResponseEntity.accepted().build();
    }
}
