package com.publicis.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publicis.assignment.enums.SeatType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="theaterseats")
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "seatNumber", nullable = false)
    private String seatNumber;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seatType", nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JsonIgnore
    private TheaterEntity theater;
}
