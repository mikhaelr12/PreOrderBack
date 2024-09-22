package md.orange.preorderback.controller;

import lombok.RequiredArgsConstructor;
import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.dto.request.RestaurantFilterDTO;
import md.orange.preorderback.service.RestaurantResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant-resource")
public class RestaurantResourceController {
    private final RestaurantResourceService restaurantResourceService;

    @PostMapping
    public ResponseEntity<List<RestaurantDTO>> getRestaurants(@RequestBody(required = false) RestaurantFilterDTO filter) {
        return ResponseEntity.ok(restaurantResourceService.getRestaurants(filter));
    }

    @GetMapping("/menu/{restaurantId}")
    public ResponseEntity<MenuDTO> getMenuByRestaurantId(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(restaurantResourceService.getMenuByRestaurantId(restaurantId));
    }

    @GetMapping("/restaurants/has-free-table/{locationId}")
    public ResponseEntity<Boolean> hasFreeTable(@PathVariable Long locationId) {
        return ResponseEntity.ok(true);
    }
}
