package com.publicis.assignment.service;


import com.publicis.assignment.dto.EntryRequestDto.TheaterEntryDto;
import com.publicis.assignment.dto.ResponseDto.TheaterResponseDto;

public interface TheaterService {
    // Add Theater
    TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);

    // Get Theater
    TheaterResponseDto getTheater(int id);
}
