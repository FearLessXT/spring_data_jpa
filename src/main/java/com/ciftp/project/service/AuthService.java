package com.ciftp.project.service;

import com.ciftp.project.auth.AuthRequest;
import com.ciftp.project.auth.AuthResponse;
import com.ciftp.project.config.JwtService;
import com.ciftp.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public ResponseEntity<?> authenticate(AuthRequest request) {
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword(),
                        grantedAuths
                )
        );
        return getGlobalResultResponseEntity(userDetails);
    }

    private ResponseEntity<?> getGlobalResultResponseEntity(UserDetails userDetails) {
        var jwtToken = jwtService.generateToken(userDetails);

        AuthResponse response = new AuthResponse();
        response.setToken(jwtToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
