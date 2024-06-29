package com.publicis.assignment.controller;

import com.publicis.assignment.dto.EntryRequestDto.UserEntryDto;
import com.publicis.assignment.dto.ResponseDto.UserResponseDto;
import com.publicis.assignment.model.UserEntity;
import com.publicis.assignment.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    
    @PostMapping("/add-user")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserEntryDto userEntryDto) {
        UserResponseDto userResponseDto = userService.addUser(userEntryDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    } 

    @GetMapping("/get-user")
    public ResponseEntity<UserResponseDto> getUser(@RequestParam(value = "id") int id) {
        UserResponseDto userResponseDto = userService.getUser(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-user")
    public ResponseEntity<List<UserEntity>> getAllUser() {
        List<UserEntity> usersList = userService.getAllUser();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }
    
}
