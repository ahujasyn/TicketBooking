package com.publicis.assignment.service;


import com.publicis.assignment.dto.BookTicketRequestDto;
import com.publicis.assignment.dto.TicketDto;
import com.publicis.assignment.model.TicketEntity;

public interface TicketService {
    // Get a Ticket
    TicketEntity getTicket(int id);

    // Booking a Ticket
    TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto);
}
