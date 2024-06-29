package com.publicis.assignment.controller;

import com.publicis.assignment.dto.BookTicketRequestDto;
import com.publicis.assignment.dto.TicketDto;
import com.publicis.assignment.model.TicketEntity;
import com.publicis.assignment.service.Impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping("/get-ticket")
    public ResponseEntity<TicketEntity> getTicketById(@RequestParam("id") int id) {
        return new ResponseEntity<>(ticketService.getTicket(id), HttpStatus.FOUND);
    }

    @PutMapping("/ticket-booking")
    public ResponseEntity<TicketDto> bookATicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) {
        return new ResponseEntity<>(ticketService.bookTicket(bookTicketRequestDto), HttpStatus.CREATED);
    }
}
