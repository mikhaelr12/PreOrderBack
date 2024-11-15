package md.orange.preorderback.service.impl;

import lombok.AllArgsConstructor;
import md.orange.preorderback.dto.UserDTO;
import md.orange.preorderback.entity.User;
import md.orange.preorderback.exception.UserException;
import md.orange.preorderback.repository.UserRepository;
import md.orange.preorderback.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(UserDTO input) {
        var user = userRepository.findByUsername(input.getUsername());
        if (user.isPresent()) {
            throw new UserException("Username is already in use");
        }
        User newUser = new User();
        newUser.setUsername(input.getUsername());
        newUser.setPassword(passwordEncoder.encode(input.getPassword()));
        newUser.setEmail(input.getEmail());
        newUser.setPhone(input.getPhone());
        userRepository.save(newUser);
    }

    public User authenticate(UserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}