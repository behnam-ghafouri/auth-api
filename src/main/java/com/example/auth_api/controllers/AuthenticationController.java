package com.example.auth_api.controllers;
import com.example.auth_api.entities.User;
import com.example.auth_api.dtos.LoginUserDto;
import com.example.auth_api.dtos.RegisterUserDto;
import com.example.auth_api.responses.LoginResponse;
import com.example.auth_api.services.AuthenticationService;
import com.example.auth_api.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
    @PostMapping("/email")
    public ResponseEntity<Object> emailPost(@RequestBody Object obj) {
        try{
            System.out.println(obj.toString());
            return ResponseEntity.ok(obj);
        }catch (Exception e){
            return ResponseEntity.ok(obj);
        }
    }
    @PutMapping("/email")
    public ResponseEntity<Object> emailPut(@RequestBody Object obj) {
        try{
            System.out.println(obj.toString());
            return ResponseEntity.ok(obj);
        }catch (Exception e){
            return ResponseEntity.ok(obj);
        }
    }
}
