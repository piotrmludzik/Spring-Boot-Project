package com.codecool.springbootproject.service;

import com.codecool.springbootproject.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {

    List<Song> findAll();
    Optional<Song> getSongById(int id);
    void deleteSongById(int id);
}
