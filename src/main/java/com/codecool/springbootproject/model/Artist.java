package com.codecool.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @OneToMany(mappedBy="artist", cascade= CascadeType.ALL, orphanRemoval=true)
    private Set<SongArtist> songArtist;

    public Artist(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Artist() {
    }
}
