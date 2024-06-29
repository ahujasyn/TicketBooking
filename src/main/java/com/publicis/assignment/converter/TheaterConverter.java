package com.publicis.assignment.converter;


import com.publicis.assignment.dto.EntryRequestDto.TheaterEntryDto;
import com.publicis.assignment.dto.ResponseDto.TheaterResponseDto;
import com.publicis.assignment.model.TheaterEntity;

public class TheaterConverter {
    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto) {
        return TheaterEntity.builder()
            .name(theaterEntryDto.getName())
            .address(theaterEntryDto.getAddress())
            .city(theaterEntryDto.getCity())
            .theaterType(theaterEntryDto.getTheaterType()).build();
    }
    
    public static TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity) {
        return TheaterResponseDto.builder()
            .name(theaterEntity.getName())
            .address(theaterEntity.getAddress())
            .city(theaterEntity.getCity())
            .theaterType(theaterEntity.getTheaterType()).build();
    }
}
