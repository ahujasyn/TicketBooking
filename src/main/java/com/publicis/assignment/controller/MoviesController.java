package com.publicis.assignment.controller;

import com.publicis.assignment.dto.EntryRequestDto.MovieEntryDto;
import com.publicis.assignment.dto.ResponseDto.MovieResponseDto;
import com.publicis.assignment.service.Impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movie")
public class MoviesController {
    @Autowired
    MovieServiceImpl movieService;

    @GetMapping(value="/get-movie")
    public ResponseEntity<MovieResponseDto> getMovie(@RequestParam("id") int id) {
        return new ResponseEntity<>(movieService.getMovie(id), HttpStatus.FOUND);
    }

    @GetMapping(value="/get-movie-name")
    public ResponseEntity<MovieResponseDto> getMovieName(@RequestParam("name") String name) {
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.FOUND);
    }
    
    @PostMapping("/add-movie")
    public ResponseEntity<MovieResponseDto> addMovie(@RequestBody MovieEntryDto movieEntryDto) {
        return new ResponseEntity<>(movieService.addMovie(movieEntryDto), HttpStatus.CREATED);
    }
}
