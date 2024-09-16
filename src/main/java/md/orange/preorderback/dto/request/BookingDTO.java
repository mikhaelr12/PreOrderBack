package md.orange.preorderback.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BookingDTO {
    private Long userId = 1L;
    @NotNull
    private Long tableId;
    private Integer noPeople = 0;
    private String preferences;
    @NotNull
    private List<Long> itemIds;
}
