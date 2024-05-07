package com.ciftp.project.controller;

import com.ciftp.project.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository repository;

    @GetMapping("/api/author")
    public String author() {
        return repository.findAuthorsByFirstName("Johnathon").toString();
    }
}
