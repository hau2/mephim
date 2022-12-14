package com.example.mephim.entity;

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
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;
    private String actorName;

//    @OneToMany(mappedBy = "movieActorId")
//    @JsonManagedReference
//    private List<MovieActor> movieActors;

    public Actor(String actorName) {
        this.actorName = actorName;
    }

    public Actor(Integer actorId) {
        this.actorId = actorId;
    }
}
