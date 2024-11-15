package md.orange.preorderback.service;

import md.orange.preorderback.dto.UserDTO;
import md.orange.preorderback.entity.User;

public interface AuthenticationService {
    void signup(UserDTO input);

    User authenticate(UserDTO input);
}
