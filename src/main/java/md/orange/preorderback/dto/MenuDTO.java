package md.orange.preorderback.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuDTO {
    private Long id;
    private List<ItemDTO> items;
}
