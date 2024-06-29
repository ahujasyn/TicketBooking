package com.publicis.assignment.dto.EntryRequestDto;

import com.publicis.assignment.enums.TheaterType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterEntryDto {
    String name;
    String address;
    String city;
    TheaterType theaterType;
}
