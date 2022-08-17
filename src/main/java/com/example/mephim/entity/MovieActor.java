package com.example.mephim.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieActorId;

    @ManyToOne
    @JoinColumn(name="actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;
}
