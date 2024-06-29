package com.publicis.assignment.dto;


import com.publicis.assignment.dto.EntryRequestDto.UserEntryDto;
import com.publicis.assignment.dto.ResponseDto.UserResponseDto;
import com.publicis.assignment.model.UserEntity;

public class UserConverter {
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto) {
        return UserEntity.builder()
            .name(userEntryDto.getName())
            .mobileNo(userEntryDto.getContactNumber()).build();
    }

    public static UserResponseDto convertEntityToDto(UserEntity user) {
        return UserResponseDto.builder()
                .id(user.getId()).name(user.getName())
                .mobNo(user.getMobileNo()).build();
    }
}
