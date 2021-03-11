package com.codecool.springbootproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="song_genre")
public class SongGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="genre_id", nullable=false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name="song_id", nullable=false)
    private Song song;

    public SongGenre(Genre genre, Song song) {
        this.genre = genre;
        this.song = song;
    }

    public SongGenre() {
    }
}
