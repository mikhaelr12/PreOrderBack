package md.orange.preorderback.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String dishName;
    private Double price;
    private String description;
    private Boolean isAvailable;
    private Byte[] image;
}
