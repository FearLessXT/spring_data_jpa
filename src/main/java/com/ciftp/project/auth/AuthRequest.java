package com.ciftp.project.auth;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
}
