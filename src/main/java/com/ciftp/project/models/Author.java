package com.ciftp.project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "f_name")
    private String firstName;

    @Column(name = "l_name")
    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    @Column(name = "age")
    private int age;

    @Column(
            updatable = false
    )
    private LocalDateTime createdAt;

    @Column(
            insertable = false
    )
    private LocalDateTime lastModifiedAt;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
