package com.publicis.assignment.service;

import com.publicis.assignment.dto.EntryRequestDto.UserEntryDto;
import com.publicis.assignment.dto.ResponseDto.UserResponseDto;
import com.publicis.assignment.model.UserEntity;

import java.util.List;



public interface UserService {
    // Add User
    UserResponseDto addUser(UserEntryDto userEntryDto);

    // Get User
    UserResponseDto getUser(int id);

    // Get All Users
    List<UserEntity> getAllUser();
}
