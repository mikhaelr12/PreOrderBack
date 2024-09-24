package md.orange.preorderback.service;

import md.orange.preorderback.dto.LocationDTO;
import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.dto.request.RestaurantFilterDTO;

import java.util.List;

public interface RestaurantResourceService {
    List<RestaurantDTO> getRestaurants(RestaurantFilterDTO filter);

    MenuDTO getMenuByRestaurantId(Long restaurantId);

    List<LocationDTO> getLocationsByRestaurantId(Long restaurantId);

    Boolean isFreeTable(Long tableId);

    void updateTableFreeStatus(Long tableId, Boolean flag);

    Double calcAndGetPrice(List<Long> items);

    String getItemsToText(List<Long> items);

    void freeTable();
}