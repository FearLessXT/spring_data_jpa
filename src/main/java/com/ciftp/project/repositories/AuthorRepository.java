package com.ciftp.project.repositories;

import com.ciftp.project.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAuthorsByFirstName(String firstName);
}