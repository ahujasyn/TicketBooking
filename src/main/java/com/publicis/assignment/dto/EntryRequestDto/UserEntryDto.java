package com.publicis.assignment.dto.EntryRequestDto;

import lombok.*;

@Data
@Builder
public class UserEntryDto {
    String name;
    String contactNumber;
    String email;
}
