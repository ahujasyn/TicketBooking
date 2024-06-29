package com.publicis.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publicis.assignment.enums.TheaterType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="theaters")
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    // @Enumerated(EnumType.STRING)
    // @Column(name = "seatType", nullable = false)
    // private SeatType seatType;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "theaterType", nullable = false)
    private TheaterType theaterType;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> showList;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheaterSeatEntity> theaterSeatList;
    
}
