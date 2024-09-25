package md.orange.preorderback.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import md.orange.preorderback.dto.LocationDTO;
import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.dto.request.RestaurantFilterDTO;
import md.orange.preorderback.service.RestaurantResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant-resource")
public class RestaurantResourceController {
    private final RestaurantResourceService restaurantResourceService;

    @PostMapping
    @Operation(summary = "Get Restaurants by filter(categoryID, name)", description = "Return a List of RestaurantDTO, " +
            " to get all restaurants make the request with null param")
    public ResponseEntity<List<RestaurantDTO>> getRestaurants(@RequestBody(required = false) RestaurantFilterDTO filter) {
        return ResponseEntity.ok(restaurantResourceService.getRestaurants(filter));
    }

    @GetMapping("/menu/{restaurantId}")
    @Operation(summary = "Get Menu by Restaurant Id", description = "Return a MenuDTO")
    public ResponseEntity<MenuDTO> getMenuByRestaurantId(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(restaurantResourceService.getMenuByRestaurantId(restaurantId));
    }

//    @GetMapping("/restaurants/has-free-table/{locationId}")
//    @Operation(summary = "Verify if has free table", description = "Return a boolean var")
//    public ResponseEntity<Boolean> hasFreeTable(@PathVariable Long locationId) {
//        return ResponseEntity.ok(restaurantResourceService.isFreeTable(locationId));
//    }


    @GetMapping("/locations/{restaurantId}")
    @Operation(summary = "Get locations by Restaurant Id", description = "Return a list of LocationDTO")
    public ResponseEntity<List<LocationDTO>> getLocationsByRestaurantId(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(restaurantResourceService.getLocationsByRestaurantId(restaurantId));
    }

    @GetMapping("/tabels/{locationId}")
    @Operation(summary = "Get free tables by Location Id", description = "Returns free tables based of a location " +
            " based by locationId")
    public ResponseEntity<?> getFreeTablesByLocationId(@PathVariable Long locationId) {
        return ResponseEntity.ok(restaurantResourceService.getFreeTablesByLocationId(locationId));
    }
}
