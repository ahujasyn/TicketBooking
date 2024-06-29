package com.publicis.assignment.service.Impl;

import com.publicis.assignment.converter.MovieConverter;
import com.publicis.assignment.converter.ShowConverter;
import com.publicis.assignment.dto.EntryRequestDto.MovieEntryDto;
import com.publicis.assignment.dto.ResponseDto.MovieResponseDto;
import com.publicis.assignment.dto.ResponseDto.ShowResponseDto;
import com.publicis.assignment.model.MovieEntity;
import com.publicis.assignment.model.ShowEntity;
import com.publicis.assignment.repository.MovieRepository;
import com.publicis.assignment.repository.ShowRepository;
import com.publicis.assignment.service.MovieService;
import com.publicis.assignment.service.ShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@Component
@Slf4j
public class MovieServiceImpl implements MovieService {


    @Autowired
    ShowService showService;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowRepository showRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {

        log.info("Adding the Movie", movieEntryDto);

        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);

        return MovieConverter.convertEntityToDto(movieEntity);
    }

    @Override
    public MovieResponseDto getMovie(int id) {
        MovieEntity movieEntity = movieRepository.findById(id).get();
        ShowEntity showEntity = showRepository.findById(id).get();
        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity);
        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        movieResponseDto.setShowDtoList(Collections.singletonList(showResponseDto));
        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovieByName(String name) {
        MovieEntity movieEntity = movieRepository.findByName(name);
         List<ShowResponseDto> showResponseDto = ShowConverter.convertEntityToDto(movieEntity.getShowsList());
        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        movieResponseDto.setShowDtoList(showResponseDto);
        return movieResponseDto;
    }
    
}
