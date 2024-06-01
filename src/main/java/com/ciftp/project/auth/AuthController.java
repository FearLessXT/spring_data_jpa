package com.ciftp.project.auth;

import com.ciftp.project.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private static final Logger logger = LogManager.getLogger(AuthController.class);
    private final AuthService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            AuthRequest request = new AuthRequest();
            request.setUsername(authRequest.getUsername());
            request.setPassword(authRequest.getPassword());
            logger.info("Authentication request: " + request);
            return authenticationService.authenticate(request);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
