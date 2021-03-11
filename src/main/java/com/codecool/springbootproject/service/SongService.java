package com.codecool.springbootproject.service;

import com.codecool.springbootproject.dao.SongRepository;
import com.codecool.springbootproject.model.Song;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SongService implements ISongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        var songs = (List<Song>) songRepository.findAll();
        return songs;
    }

    @Override
    public Optional<Song> getSongById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteSongById(int id) {
        songRepository.deleteById(id);
    }
}
