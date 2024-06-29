package com.publicis.assignment.converter;


import com.publicis.assignment.dto.EntryRequestDto.ShowEntryDto;
import com.publicis.assignment.dto.ResponseDto.ShowResponseDto;
import com.publicis.assignment.model.ShowEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ShowConverter {
    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto) {
        return ShowEntity.builder().showDate(showEntryDto.getShowDate()).
        showTime(showEntryDto.getShowTime()).build();
    }
    
    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity){

        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .build();
    }

    public static List<ShowResponseDto> convertEntityToDto(List<ShowEntity> showEntities){

        return showEntities.stream()
                .map(showEntity -> ShowResponseDto.builder()
                        .id(showEntity.getId())
                        .showTime(showEntity.getShowTime())
                        .showDate(showEntity.getShowDate())
                        .build())
                .collect(Collectors.toList());
    }
}
