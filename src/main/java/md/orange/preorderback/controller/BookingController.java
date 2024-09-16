package md.orange.preorderback.controller;

import io.swagger.v3.oas.annotations.Operation;
import md.orange.preorderback.dto.request.BookingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @PutMapping
    @Operation(description = "test")
    public ResponseEntity<?> validateAndBook(@RequestBody BookingDTO bookingDTO) {
//        return ResponseEntity.status(HttpStatusCode.valueOf(409)).body(new ErrorDetailsDTO());
        return ResponseEntity.accepted().body(null);
    }
}
