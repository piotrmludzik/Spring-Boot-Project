package com.codecool.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="song_genre")
public class SongGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false, nullable=false)
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
