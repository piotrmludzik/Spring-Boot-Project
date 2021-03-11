package com.codecool.springbootproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="song_album")
public class SongAlbum {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
