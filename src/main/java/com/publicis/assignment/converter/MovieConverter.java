package com.publicis.assignment.converter;


import com.publicis.assignment.dto.EntryRequestDto.MovieEntryDto;
import com.publicis.assignment.dto.ResponseDto.MovieResponseDto;
import com.publicis.assignment.model.MovieEntity;

public class MovieConverter {
    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto) {
        return MovieEntity.builder()
                .name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate()).build();
    }
    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity) {
        return MovieResponseDto.builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName())
                .releaseDate(movieEntity.getReleaseDate()).build();
    }
}
