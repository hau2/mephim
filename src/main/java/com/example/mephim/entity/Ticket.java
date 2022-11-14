package com.example.mephim.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private Long ticketPrice;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "bookingId")
    @JsonIgnore
    private List<Booking> bookingList;

    @ManyToOne
    @JoinColumn(name="show_date_id")
    private ShowDate showDate;

    @ManyToOne
    @JoinColumn(name="show_time_id")
    private ShowTime showTime;

    private Boolean active;

    public Ticket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(Integer ticketId, Long ticketPrice, Movie movie){
        this.ticketId = ticketId;
        this.ticketPrice = ticketPrice;
        this.movie = movie;
    }
}
