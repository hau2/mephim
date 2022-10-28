package com.example.mephim.entity;

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
public class ShowDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showDateId;

    @Column(name = "date", columnDefinition = "DATE")
    private String date;

    @OneToMany(mappedBy = "movieId")
    @JsonManagedReference
    private List<Movie> movieList;

    @OneToMany(mappedBy = "showTimeId")
    @JsonManagedReference
    private List<ShowTime> showTimeList;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="show_time_id")
    private ShowTime showTime;

    @OneToMany(mappedBy = "ticketId")
    @JsonManagedReference
    private List<Ticket> ticketList;
}