package md.orange.preorderback.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import md.orange.preorderback.enums.Role;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String phone;
    private Role role;
}
