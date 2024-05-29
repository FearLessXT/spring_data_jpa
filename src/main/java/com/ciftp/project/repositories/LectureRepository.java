package com.ciftp.project.repositories;

import com.ciftp.project.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

    @Query("select u from Lecture u where u.name = :name")
    Lecture findByName(String name);

}
