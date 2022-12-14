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

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TheaterGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterGroupId;
    private String theaterName;

    @OneToMany(mappedBy = "theaterGroup")
    @JsonIgnore
    private List<Theater> theaterList;

    public TheaterGroup(String theaterName) {
        this.theaterName = theaterName;
    }
}
