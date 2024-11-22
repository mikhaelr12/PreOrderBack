package md.orange.preorderback.service.impl;

import lombok.AllArgsConstructor;
import md.orange.preorderback.dto.LocationDTO;
import md.orange.preorderback.dto.RestaurantDTO;
import md.orange.preorderback.entity.Location;
import md.orange.preorderback.entity.Restaurant;
import md.orange.preorderback.repository.LocationRepository;
import md.orange.preorderback.repository.RestaurantRepository;
import md.orange.preorderback.service.RestaurantManagerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantManagerServiceImpl implements RestaurantManagerService {

    private final RestaurantRepository restaurantRepository;
    private final LocationRepository locationRepository;

    @Override
    public void addRestaurant(RestaurantDTO restaurantDTO, Long CategoryId) {
        // Salvare restaurant
        Restaurant restaurant = Restaurant.builder()
                .restaurantName(restaurantDTO.getRestaurantName())
                .categoryId(CategoryId)
                .build();
         restaurant = restaurantRepository.save(restaurant);

        // Salvare locații asociate
        if (restaurantDTO.getLocations() != null) {
            Restaurant finalRestaurant = restaurant;
            List<Location> locations = restaurantDTO.getLocations().stream()
                    .map(locationDTO -> Location.builder()
                            .address(locationDTO.getAddress())
                            .restaurantId(finalRestaurant.getId())
                            .build())
                    .collect(Collectors.toList());
            locationRepository.saveAll(locations);
        }
    }

    @Override
    public void deleteRestaurant(Long id) {
        // Ștergere locații asociate
        locationRepository.deleteByRestaurantId(id);

        // Ștergere restaurant
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found!"));
        restaurantRepository.delete(restaurant);
    }

    @Override
    public void updateRestaurant(Long id, RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found!"));

        if (restaurantDTO.getRestaurantName() != null) {
            restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        }
        if (restaurantDTO.getLogo() != null) {
            restaurant.setLogo(new String(restaurantDTO.getLogo()));
        }

        restaurantRepository.save(restaurant);

        if (restaurantDTO.getLocations() != null) {
            // Ștergere locații existente și salvare locații noi
            locationRepository.deleteByRestaurantId(restaurant.getId());
            List<Location> locations = restaurantDTO.getLocations().stream()
                    .map(locationDTO -> Location.builder()
                            .address(locationDTO.getAddress())
                            .restaurantId(restaurant.getId())
                            .build())
                    .collect(Collectors.toList());
            locationRepository.saveAll(locations);
        }
    }
}
