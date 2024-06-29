package com.publicis.assignment.service;


import com.publicis.assignment.dto.EntryRequestDto.ShowEntryDto;
import com.publicis.assignment.dto.ResponseDto.ShowResponseDto;

public interface ShowService {
    // Add Show
    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    // Get Show
    ShowResponseDto getShow(int id);
}
