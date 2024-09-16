package md.orange.preorderback.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantFilterDTO {
    private List<Long> categoryIds;
    private String restaurantName;
    private Boolean freeTable;
}
