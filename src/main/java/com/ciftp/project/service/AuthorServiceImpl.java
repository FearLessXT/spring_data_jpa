package com.ciftp.project.service;

import com.ciftp.project.models.Author;
import com.ciftp.project.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{


    private final AuthorRepository authorRepository;

    @Override
    public String findByName(String name) {
        List<Author> authors = authorRepository.findAuthorsByFirstName(name);
        return authors.toString();
    }
}
