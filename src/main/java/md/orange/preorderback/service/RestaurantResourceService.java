package md.orange.preorderback.service;

import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.dto.request.RestaurantFilterDTO;

import java.util.List;

public interface RestaurantResourceService {
    List<RestaurantDTO> getRestaurants(RestaurantFilterDTO filter);
    MenuDTO getMenuByRestaurantId(Long restaurantId);
}
