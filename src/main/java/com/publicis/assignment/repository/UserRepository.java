package com.publicis.assignment.repository;


import com.publicis.assignment.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
}
