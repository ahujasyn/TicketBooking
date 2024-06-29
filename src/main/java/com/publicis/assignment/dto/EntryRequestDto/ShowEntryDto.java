package com.publicis.assignment.dto.EntryRequestDto;

import com.publicis.assignment.dto.ResponseDto.MovieResponseDto;
import com.publicis.assignment.dto.ResponseDto.TheaterResponseDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Builder
public class ShowEntryDto {
    LocalDate showDate;

    LocalTime showTime;

    MovieResponseDto movieResponseDto;

    TheaterResponseDto theaterResponseDto;
}
