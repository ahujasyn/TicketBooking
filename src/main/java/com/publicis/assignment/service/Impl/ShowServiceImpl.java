package com.publicis.assignment.service.Impl;

import com.publicis.assignment.converter.ShowConverter;
import com.publicis.assignment.dto.EntryRequestDto.ShowEntryDto;
import com.publicis.assignment.dto.ResponseDto.ShowResponseDto;
import com.publicis.assignment.model.*;
import com.publicis.assignment.repository.MovieRepository;
import com.publicis.assignment.repository.ShowRepository;
import com.publicis.assignment.repository.ShowSeatRepository;
import com.publicis.assignment.repository.TheaterRepository;
import com.publicis.assignment.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Component
public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    
    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);
        
        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();
        
        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterResponseDto().getId()).get();
        
        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theaterEntity);

        showRepository.save(showEntity);

        generateShowEntitySeats(theaterEntity.getTheaterSeatList(), showEntity);
        
        showRepository.save(showEntity);
        
        return ShowConverter.convertEntityToDto(showEntity);
    }

    void generateShowEntitySeats(List<TheaterSeatEntity> theaterSeatList, ShowEntity showEntity) {
        List<ShowSeatsEntity> showSeatEntityList = new ArrayList<>();
        
        for(TheaterSeatEntity tse : theaterSeatList) {
            ShowSeatsEntity showSeatEntity = ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber()).
                rate(tse.getRate()).seatType(tse.getSeatType()).build();
            
            showSeatEntity.setShow(showEntity); // Belonging show with these virtual showseat
            
            showSeatEntityList.add(showSeatEntity);
        }

        // Saving all seats in repository
        showSeatRepository.saveAll(showSeatEntityList);

        // adding seatsList in show
        showEntity.setShowSeatList(showSeatEntityList);
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowEntity showEntity = showRepository.findById(id).get();
        return ShowConverter.convertEntityToDto(showEntity);
    }
    
}
