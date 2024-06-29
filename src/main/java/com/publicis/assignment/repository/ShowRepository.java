package com.publicis.assignment.repository;


import com.publicis.assignment.model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {

     ShowEntity findByMovieIdAndTheaterIdAndShowTime(int showId, int theaterId, LocalTime showTime);
}
