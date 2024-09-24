package md.orange.preorderback.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;
    @Email
    private String mail;
    private Integer noPeople = 0;
    private String preferences;
    @NotNull
    private Long locationId;
    private Long tableId;
    @NotNull
    private List<Long> itemIds;
}
