package md.orange.preorderback.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.dto.ItemDTO;
import md.orange.preorderback.dto.LocationDTO;
import md.orange.preorderback.dto.MenuDTO;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.dto.request.RestaurantFilterDTO;
import md.orange.preorderback.entity.Item;
import md.orange.preorderback.entity.Location;
import md.orange.preorderback.entity.Menu;
import md.orange.preorderback.entity.Restaurant;
import md.orange.preorderback.repository.ItemRepository;
import md.orange.preorderback.repository.LocationRepository;
import md.orange.preorderback.repository.MenuRepository;
import md.orange.preorderback.repository.RestaurantRepository;
import md.orange.preorderback.service.RestaurantResourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantResourceServiceImpl implements RestaurantResourceService {
    private final RestaurantRepository restaurantRepository;
    private final LocationRepository locationRepository;
    private final MenuRepository menuRepository;
    private final ItemRepository itemRepository;

    @Override
    public List<RestaurantDTO> getRestaurants(RestaurantFilterDTO filter) {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        if (filter != null && !filter.getCategoryIds().isEmpty()) {
            restaurants = restaurants.stream()
                    .filter(r -> filter.getCategoryIds().contains(r.getCategoryId()))
                    .toList();
        }

        if (filter != null && StringUtils.hasText(filter.getRestaurantName())) {
            restaurants = restaurants.stream()
                    .filter(r -> r.getRestaurantName().toLowerCase().contains(filter.getRestaurantName().toLowerCase()))
                    .toList();
        }

        List<RestaurantDTO> restaurantDTOS = restaurants.stream()
                .map(r -> RestaurantDTO.builder()
                        .id(r.getId())
                        .restaurantName(r.getRestaurantName())
                        .logo(r.getLogo())
                        .build()
                ).toList();

        for (RestaurantDTO r : restaurantDTOS) {
            List<Location> locations = locationRepository.findByRestaurantId(r.getId());

            List<LocationDTO> locationDTOS = locations.stream()
                    .map(l -> LocationDTO.builder()
                            .id(l.getId())
                            .address(l.getAddress())
                            .build()
                    ).toList();
            r.setLocations(locationDTOS);
        }
        return restaurantDTOS;
    }

    @Override
    public MenuDTO getMenuByRestaurantId(Long restaurantId) {
        Optional<Menu> menu = menuRepository.findByRestaurantId(restaurantId);
        if (menu.isPresent()) {
            List<Item> items = itemRepository.findByMenuId(menu.get().getRestaurantId());
            List<ItemDTO> itemDTOS = items.stream()
                    .map(item -> ItemDTO.builder()
                            .id(item.getId())
                            .dishName(item.getDishName())
                            .price(item.getPrice())
                            .description(item.getDescription())
                            .image(item.getImage())
                            .isAvailable(item.getIsAvailable())
                            .build())
                    .toList();

            return MenuDTO.builder()
                    .id(menu.get().getId())
                    .items(itemDTOS)
                    .build();
        }
        throw new RuntimeException("Menu not found by id " + restaurantId);
    }
}
