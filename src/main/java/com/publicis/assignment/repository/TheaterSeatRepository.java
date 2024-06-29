package com.publicis.assignment.repository;


import com.publicis.assignment.model.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity, Integer> {
    
}
