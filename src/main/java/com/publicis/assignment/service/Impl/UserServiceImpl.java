package com.publicis.assignment.service.Impl;

import com.publicis.assignment.dto.EntryRequestDto.UserEntryDto;
import com.publicis.assignment.dto.ResponseDto.UserResponseDto;
import com.publicis.assignment.dto.UserConverter;
import com.publicis.assignment.model.UserEntity;
import com.publicis.assignment.repository.UserRepository;
import com.publicis.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserEntryDto userEntryDto) {
        UserEntity userEntity = UserConverter.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
        return UserConverter.convertEntityToDto(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {
        UserEntity user = userRepository.findById(id).get();

        UserResponseDto userResponseDto = UserConverter.convertEntityToDto(user);

        return userResponseDto;
    }

    @Override
    public List<UserEntity> getAllUser() {
        List<UserEntity> usersList = userRepository.findAll();
        return usersList;
    }
    
}



























