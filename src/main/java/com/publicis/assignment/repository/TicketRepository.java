package com.publicis.assignment.repository;


import com.publicis.assignment.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
    
}
