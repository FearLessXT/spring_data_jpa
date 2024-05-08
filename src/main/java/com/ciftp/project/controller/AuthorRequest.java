package com.ciftp.project.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorRequest {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
