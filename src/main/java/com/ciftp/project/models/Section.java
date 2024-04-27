package com.ciftp.project.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "SECTION")
public class Section extends BaseEntity {

    private String name;

    private int pageOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
