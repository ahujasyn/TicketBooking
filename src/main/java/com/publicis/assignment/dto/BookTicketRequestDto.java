package com.publicis.assignment.dto;

import com.publicis.assignment.enums.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookTicketRequestDto {
    Set<String> requestedSeat;
    int userId;
    int showId;
    SeatType seatType;
}

/*
 1. a DTO is a lighter weight class included only relevent information
    and to avoid heavy loaded unrelevent information

 2.  a DTO can contain information from a Entity
    also can contains atributes from different classes like boookTicketRequest;
 */