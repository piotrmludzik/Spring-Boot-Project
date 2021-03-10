package com.codecool.springbootproject.service;

import com.codecool.springbootproject.dao.SongRepository;
import com.codecool.springbootproject.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        var songs = (List<Song>) songRepository.findAll();
        return songs;
    }
}
