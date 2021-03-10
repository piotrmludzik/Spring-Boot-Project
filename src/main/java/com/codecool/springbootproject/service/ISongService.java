package com.codecool.springbootproject.service;

import com.codecool.springbootproject.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
}
