package md.orange.preorderback.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.dto.*;
import md.orange.preorderback.dto.request.RestaurantFilterDTO;
import md.orange.preorderback.entity.*;
import md.orange.preorderback.exception.BookingException;
import md.orange.preorderback.repository.*;
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
    private final TableRepository tableRepository;

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
        //todo create custom exception
        throw new RuntimeException("Menu not found by id " + restaurantId);
    }

    @Override
    public List<LocationDTO> getLocationsByRestaurantId(Long restaurantId) {
        List<Location> locations = locationRepository.findByRestaurantId(restaurantId);
        if (!locations.isEmpty()) {
            return locations.stream()
                    .map(location -> LocationDTO.builder()
                            .id(location.getId())
                            .address(location.getAddress())
                            .build()
                    ).toList();
        }
        //todo create custom exception
        throw new RuntimeException("Location not found by id " + restaurantId);
    }

    @Override
    public List<TableDTO> getTablesByLocationId(Long locationId) {
        log.info("Get tables by location id {}", locationId);
        return tableRepository.getTablesByLocationId(locationId).stream()
                .map(t -> TableDTO.builder()
                        .id(t.getId())
                        .locationId(t.getLocationId())
                        .isFree(t.getIsFree())
                        .build()
                ).toList();
    }

    @Override
    public Boolean isFreeTable(Long tableId) {
        Optional<Table> table = tableRepository.findById(tableId);
        if (table.isEmpty()) {
            throw new BookingException("Service currently unavailable, please try a little later!");
        }
        return table.get().getIsFree();
    }

    @Override
    public void updateTableFreeStatus(Long tableId, Boolean status) {
        tableRepository.updateTableFreeStatus(tableId, status);
    }

    @Override
    public Double calcAndGetPrice(List<Long> items) {
        List<Item> itemList = itemRepository.findAllById(items);

        Double price = 0.0;

        for (Item item : itemList) {
            price += item.getPrice();
        }

        return price;
    }

    @Override
    public String getItemsToText(List<Long> items) {
        StringBuilder text = new StringBuilder();
        List<Item> itemList = itemRepository.findAllById(items);
        for (Item item : itemList) {
            text.append(item.getDishName()).append(" - ").append(item.getPrice()).append("\n");
        }
        return text.toString();
    }

    @Override
    public void freeTable() {
        tableRepository.freeTable();
    }
}