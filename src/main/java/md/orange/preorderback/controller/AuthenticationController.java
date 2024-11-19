package md.orange.preorderback.controller;

import lombok.AllArgsConstructor;
import md.orange.preorderback.dto.UserDTO;
import md.orange.preorderback.entity.User;
import md.orange.preorderback.entity.response.LoginResponse;
import md.orange.preorderback.service.AuthenticationService;
import md.orange.preorderback.service.impl.JwtServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final JwtServiceImpl jwtService;

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO input) {
        authenticationService.signup(input);
        return ResponseEntity.ok("Successful registration");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDTO input) {
        User authenticatedUser = authenticationService.authenticate(input);
        String token = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}