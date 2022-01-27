package com.example.genarateinterest.controller;

import com.example.genarateinterest.dto.LoginRequest;
import com.example.genarateinterest.security.JwtTokenProvider;
import com.example.genarateinterest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }


    @PostMapping(path = "/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
//        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));

        //response mapping
        /*LoginUser user = userRepository.findByUsernameAndTerminatedDateIsNull(loginRequest.getUsername()).orElseThrow(() ->
                new UsernameNotFoundException("LoginUser not found with username : " + loginRequest.getUsername())
        );
        LoginResponse loginResponse = new LoginResponse(jwt, changeUserEntityToUsrDto.apply(user));*/
//        Response<LoginResponse> response = new Response<>(200, loginResponse);
        return ResponseEntity.ok(userService.loginResponseMapping(jwt, loginRequest));
    }
}
