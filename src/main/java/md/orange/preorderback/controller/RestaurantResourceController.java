package md.orange.preorderback.controller;

import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.dto.request.RestaurantFilterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurant-resource")
public class RestaurantResourceController {

    @PostMapping
    public ResponseEntity<List<RestaurantDTO>> getRestaurants(@RequestBody(required = false) RestaurantFilterDTO filter) {
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        return ResponseEntity.ok(restaurantDTOList);
    }

    @GetMapping("/menu/{locationId}")
    public ResponseEntity<MenuDTO> getMenuByLocationId(@PathVariable Long locationId) {
        return ResponseEntity.ok(new MenuDTO());
    }
}
