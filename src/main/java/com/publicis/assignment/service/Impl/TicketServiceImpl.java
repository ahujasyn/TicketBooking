package com.publicis.assignment.service.Impl;

import com.publicis.assignment.converter.TicketConverter;
import com.publicis.assignment.dto.BookTicketRequestDto;
import com.publicis.assignment.dto.TicketDto;
import com.publicis.assignment.exception.SeatsNotAvailableException;
import com.publicis.assignment.model.ShowEntity;
import com.publicis.assignment.model.ShowSeatsEntity;
import com.publicis.assignment.model.TicketEntity;
import com.publicis.assignment.model.UserEntity;
import com.publicis.assignment.repository.ShowRepository;
import com.publicis.assignment.repository.TicketRepository;
import com.publicis.assignment.repository.UserRepository;
import com.publicis.assignment.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



@Service
@Component
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    
    @Override
    public TicketEntity getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get(); 
        return ticketEntity;
    }

    @Override
    public TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getUserId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        Set<String> requestedSeat = bookTicketRequestDto.getRequestedSeat();
        List<ShowSeatsEntity> showSeatsList = showEntity.getShowSeatList();

        // ## Option 1 to filter all seat based on some filter condition
        List<ShowSeatsEntity> bookedSeats = showSeatsList
                .stream()
                .filter( seat-> requestedSeat.contains(seat.getSeatNumber()) && !seat.isBooked() &&
                seat.getSeatType().equals(bookTicketRequestDto.getSeatType()) )
                .collect(Collectors.toList());
                

        if(bookedSeats.size() < requestedSeat.size()) {
            // This means All the seats are not Available;
            throw new SeatsNotAvailableException("Seats Are Not Available");
        }

        TicketEntity ticketEntity = TicketEntity.builder()
                        .user(userEntity)
                        .show(showEntity)
                        .seatList(bookedSeats)
                        .build();

        double amount = 0;
        String allotedSeat = "";

        for(ShowSeatsEntity seat : bookedSeats) {
            seat.setBooked(true);
            seat.setBookedAt(new Date());
            seat.setTicket(ticketEntity);

            allotedSeat += seat.getSeatNumber()+" ";
            amount += seat.getRate();
        }
        
        ticketEntity.setAllotedSeats(allotedSeat);
        ticketEntity.setAmount(amount);

        //Connect in the Show and the user
        showEntity.getTicketList().add(ticketEntity);


        //Add the ticket in the tickets list of the user Entity
        userEntity.getTicketList().add(ticketEntity);

        //saving this ticket
        ticketRepository.save(ticketEntity);

        return TicketConverter.convertEntityToDto(ticketEntity);
    }
    
}
