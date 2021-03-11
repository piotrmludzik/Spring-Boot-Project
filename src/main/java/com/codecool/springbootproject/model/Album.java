package com.codecool.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @OneToMany(mappedBy="album", cascade= CascadeType.ALL, orphanRemoval=true)
    private Set<SongAlbum> songAlbum;

    public Album(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Album() {
    }
}
