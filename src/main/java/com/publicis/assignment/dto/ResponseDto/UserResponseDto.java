package com.publicis.assignment.dto.ResponseDto;


import com.publicis.assignment.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {
    int id;
    String name;
    String mobNo;
    // optional
    List<TicketDto> tickets;
}
