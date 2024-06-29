package com.publicis.assignment.repository;


import com.publicis.assignment.model.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
    
}
