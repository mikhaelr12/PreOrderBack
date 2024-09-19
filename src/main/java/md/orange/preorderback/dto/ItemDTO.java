package md.orange.preorderback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private String dishName;
    private Double price;
    private String description;
    private Boolean isAvailable;
    private Byte[] image;
}
