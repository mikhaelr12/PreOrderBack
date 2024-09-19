package md.orange.preorderback.controller;

import lombok.RequiredArgsConstructor;
import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.dto.request.RestaurantFilterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant-resource")
public class RestaurantResourceController {

    @PostMapping
    public ResponseEntity<List<RestaurantDTO>> getRestaurants(@RequestBody(required = false) RestaurantFilterDTO filter) {
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        return ResponseEntity.ok(restaurantDTOList);
    }

    @GetMapping("/menu/{restaurantId}")
    public ResponseEntity<MenuDTO> getMenuByRestaurantId(@PathVariable Long locationId) {
        //return ResponseEntity.ok(locationId);
        return null;
    }

    @GetMapping("/restaurants/{categoryId}")
    public ResponseEntity<List<RestaurantDTO>> getRestaurantsByCategoryId(@PathVariable Long categoryId) {
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        return null;
    }
}
