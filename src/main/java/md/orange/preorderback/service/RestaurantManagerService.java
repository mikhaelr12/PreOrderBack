package md.orange.preorderback.service;

import md.orange.preorderback.dto.RestaurantDTO;

public interface RestaurantManagerService {
    void addRestaurant(RestaurantDTO restaurantDTO);
    void deleteRestaurant(Long id);
    void updateRestaurant(Long id, RestaurantDTO restaurantDTO);
}