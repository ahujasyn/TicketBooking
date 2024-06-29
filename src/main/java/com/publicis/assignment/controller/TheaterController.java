package com.publicis.assignment.controller;

import com.publicis.assignment.dto.EntryRequestDto.TheaterEntryDto;
import com.publicis.assignment.dto.ResponseDto.TheaterResponseDto;
import com.publicis.assignment.service.Impl.TheaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterServiceImpl theaterService;

    @GetMapping("/get-theater")
    public ResponseEntity<TheaterResponseDto> getTheater(@RequestParam("id") int id) {
        return new ResponseEntity<>(theaterService.getTheater(id) , HttpStatus.FOUND);
    }

    @PostMapping("/add-theater")
    public ResponseEntity<TheaterResponseDto> addTheater(@RequestBody TheaterEntryDto theaterEntryDto) {
        return new ResponseEntity<>(theaterService.addTheater(theaterEntryDto), HttpStatus.CREATED);
    }

}
