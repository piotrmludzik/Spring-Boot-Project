package com.codecool.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="song_album")
public class SongAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false, nullable=false)
    private int id;

    @ManyToOne
    @JoinColumn(name="album_id", nullable=false)
    private Album album;

    @ManyToOne
    @JoinColumn(name="song_id", nullable=false)
    private Song song;

    public SongAlbum(Album album, Song song) {
        this.album = album;
        this.song = song;
    }

    public SongAlbum() {
    }
}
