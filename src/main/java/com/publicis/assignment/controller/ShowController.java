package com.publicis.assignment.controller;

import com.publicis.assignment.dto.EntryRequestDto.ShowEntryDto;
import com.publicis.assignment.dto.ResponseDto.ShowResponseDto;
import com.publicis.assignment.service.Impl.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowServiceImpl showService;

    @GetMapping("/get-show")
    public ResponseEntity<ShowResponseDto> getShow(@RequestParam("id") int id) {
        return new ResponseEntity<>(showService.getShow(id), HttpStatus.FOUND);
    }

    @PostMapping("/add-show")
    public ResponseEntity<ShowResponseDto> addShow(@RequestBody ShowEntryDto showEntryDto) {
        return new ResponseEntity<>(showService.addShow(showEntryDto), HttpStatus.CREATED);
    }
}
