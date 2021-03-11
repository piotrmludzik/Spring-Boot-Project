package com.codecool.springbootproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Song> song;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }
}
