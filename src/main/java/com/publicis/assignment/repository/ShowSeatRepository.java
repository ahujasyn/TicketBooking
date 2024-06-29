package com.publicis.assignment.repository;

import com.publicis.assignment.model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShowSeatRepository extends JpaRepository<ShowSeatsEntity,Integer> {
    
}
