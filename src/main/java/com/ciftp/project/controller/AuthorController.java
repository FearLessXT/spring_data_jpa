package com.ciftp.project.controller;

import com.ciftp.project.controller.specification.AuthorSpecification;
import com.ciftp.project.models.Author;
import com.ciftp.project.repositories.AuthorRepository;
import com.ciftp.project.repositories.LectureRepository;
import com.ciftp.project.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final LectureRepository lectureRepository;

    @PostMapping("/api/author")
    public ResponseEntity<?> author(@RequestBody AuthorRequest authorRequest) {

        Specification<Author> specification = Specification
                .where(AuthorSpecification.hasAge(authorRequest.getAge()))
                .or(AuthorSpecification.firstNameContain("M"));

        var response = authorRepository.findAll(specification);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("api/lecture")
    public ResponseEntity<?> lecture(@RequestBody LectureRequest lectureRequest) {

        var response = lectureRepository.findByName(lectureRequest.getName());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
