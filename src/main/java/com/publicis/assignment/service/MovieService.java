package com.publicis.assignment.service;


import com.publicis.assignment.dto.EntryRequestDto.MovieEntryDto;
import com.publicis.assignment.dto.ResponseDto.MovieResponseDto;

public interface MovieService {
    // Add Movie
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);
    
    // Get Movie
    MovieResponseDto getMovie(int id);

    MovieResponseDto getMovieByName(String name);

}
