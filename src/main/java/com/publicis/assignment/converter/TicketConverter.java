package com.publicis.assignment.converter;


import com.publicis.assignment.dto.TicketDto;
import com.publicis.assignment.model.TicketEntity;

public class TicketConverter {

    public static TicketDto convertEntityToDto(TicketEntity ticket) {
        return TicketDto.builder()
                .id(ticket.getId())
                .amount(ticket.getAmount())
                .alotedSeats(ticket.getAllotedSeats()).build();
    }
}
