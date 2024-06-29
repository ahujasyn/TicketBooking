package com.publicis.assignment.service.Impl;


import com.publicis.assignment.converter.TheaterConverter;
import com.publicis.assignment.dto.EntryRequestDto.TheaterEntryDto;
import com.publicis.assignment.dto.ResponseDto.TheaterResponseDto;
import com.publicis.assignment.enums.SeatType;
import com.publicis.assignment.model.TheaterEntity;
import com.publicis.assignment.model.TheaterSeatEntity;
import com.publicis.assignment.repository.TheaterRepository;
import com.publicis.assignment.repository.TheaterSeatRepository;
import com.publicis.assignment.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {
        // we need a thater entity
        TheaterEntity theaterEntity = TheaterConverter.convertDtoToEntity(theaterEntryDto);
        
        // create theater Seats
        List<TheaterSeatEntity> seats = createTheaterSeats();
        for(TheaterSeatEntity theaterSeatEntity : seats) {
            theaterSeatEntity.setTheater(theaterEntity);
        }

        theaterRepository.save(theaterEntity);

        return TheaterConverter.convertEntityToDto(theaterEntity);
    }

    List<TheaterSeatEntity> createTheaterSeats() {
        List<TheaterSeatEntity> seats = new ArrayList<>();
        
        seats.add(getTheaterSeat("1A", 100, SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B", 100, SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C", 100, SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D", 100, SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E", 100, SeatType.CLASSIC));
        
        seats.add(getTheaterSeat("2A", 100, SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B", 100, SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C", 100, SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D", 100, SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E", 100, SeatType.PREMIUM));

        theaterSeatRepository.saveAll(seats);

        return seats;
    }

    TheaterSeatEntity getTheaterSeat(String seatNumber, int rate, SeatType seatType) {
        return TheaterSeatEntity.builder().seatNumber(seatNumber).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheaterResponseDto getTheater(int id) {
        TheaterEntity theaterEntity = theaterRepository.findById(id).get();
         return TheaterConverter.convertEntityToDto(theaterEntity);
    }
    
}
