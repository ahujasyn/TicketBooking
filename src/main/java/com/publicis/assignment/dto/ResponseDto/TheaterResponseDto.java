package com.publicis.assignment.dto.ResponseDto;

import com.publicis.assignment.enums.TheaterType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterResponseDto {
    int id;
    String name;
    String address;
    String city;
    TheaterType theaterType;
}
