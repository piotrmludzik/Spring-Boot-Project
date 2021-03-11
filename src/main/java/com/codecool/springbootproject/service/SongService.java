package com.codecool.springbootproject.service;

import com.codecool.springbootproject.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {

    List<Song> findAllSongs();
    Optional<Song> getSongById(int id);
    void deleteSongById(int id);
    void addNewSong(Song song);
    long getSongCount();
}
