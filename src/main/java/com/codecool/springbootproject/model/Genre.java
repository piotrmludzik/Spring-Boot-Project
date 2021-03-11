package com.codecool.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy="genre", cascade= CascadeType.ALL, orphanRemoval=true)
    private Set<SongGenre> songGenre;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }
}
