package md.orange.preorderback.service;

import md.orange.preorderback.dto.LocationDTO;
import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.dto.TableDTO;
import md.orange.preorderback.dto.request.RestaurantFilterDTO;
import md.orange.preorderback.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantResourceService {
    List<RestaurantDTO> getRestaurants(RestaurantFilterDTO filter);

    MenuDTO getMenuByRestaurantId(Long restaurantId);

    List<LocationDTO> getLocationsByRestaurantId(Long restaurantId);

    List<TableDTO> getFreeTablesByLocationId(Long locationId);

    Boolean isFreeTable(Long tableId);

    void updateTableFreeStatus(Long tableId, Boolean flag);

    Double calcAndGetPrice(List<Long> items);

    String getItemsToText(List<Long> items);

    void freeTable();

    Optional<Restaurant> findRestaurantByLocationId(Long locationId);
}