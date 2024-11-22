package md.orange.preorderback.controller;

import lombok.AllArgsConstructor;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.service.RestaurantManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant-manager")
@AllArgsConstructor
public class RestaurantManagerController {

    private final RestaurantManagerService restaurantManagerService;

    @PostMapping
    public ResponseEntity<?> addRestaurant(@RequestBody RestaurantDTO restaurantDTO, Long CategoryId) {
        restaurantManagerService.addRestaurant(restaurantDTO, CategoryId);
        return ResponseEntity.ok("Restaurant added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id) {
        restaurantManagerService.deleteRestaurant(id);
        return ResponseEntity.ok("Restaurant deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantDTO restaurantDTO) {
        restaurantManagerService.updateRestaurant(id, restaurantDTO);
        return ResponseEntity.ok("Restaurant updated");
    }
}
