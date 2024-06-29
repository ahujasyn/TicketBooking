package com.publicis.assignment.repository;

import com.publicis.assignment.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    MovieEntity findByName(String name);
}
