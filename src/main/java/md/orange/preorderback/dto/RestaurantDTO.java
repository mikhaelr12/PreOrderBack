package md.orange.preorderback.dto;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantDTO {
    private Long id;
    private String restaurantName;
    private Byte[] logo;
    private List<LocationDTO> locations;
    private Boolean freeTables;
}
