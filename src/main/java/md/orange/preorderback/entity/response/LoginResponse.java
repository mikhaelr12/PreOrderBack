package md.orange.preorderback.entity.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String token;

    private Long expiresIn;
}
