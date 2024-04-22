package com.ciftp.project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SECTION")
public class Section {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int pageOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
