package com.ciftp.project.repository;

import com.ciftp.project.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByMsisdn(String msisdn);
}
