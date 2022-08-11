package com.example.mephim.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public class SeatColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer columnId;
    private String columnName;

    @OneToMany(mappedBy = "seatId")
    @JsonManagedReference
    private List<Seat> seats;

}
