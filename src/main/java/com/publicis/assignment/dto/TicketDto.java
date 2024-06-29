package com.publicis.assignment.dto;

import com.publicis.assignment.dto.ResponseDto.ShowResponseDto;
import com.publicis.assignment.dto.ResponseDto.UserResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {
    int id;
    String alotedSeats;
    double amount;
    UserResponseDto user;
    ShowResponseDto show;
}
