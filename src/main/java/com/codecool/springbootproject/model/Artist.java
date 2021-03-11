package com.codecool.springbootproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Song> song;

    public Artist(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Artist() {
    }
}
