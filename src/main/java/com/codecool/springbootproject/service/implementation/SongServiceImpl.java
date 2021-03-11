package com.codecool.springbootproject.service.implementation;

import com.codecool.springbootproject.repository.SongRepository;
import com.codecool.springbootproject.model.Song;
import com.codecool.springbootproject.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SongServiceImpl implements SongService {

    SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAllSongs() {
        return (List<Song>) songRepository.findAll();
    }

    @Override
    public Optional<Song> getSongById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteSongById(int id) {
        songRepository.deleteById(id);
    }

    @Override
    public void addNewSong(Song song) {
        log.info("addNewSong called");
        songRepository.save(song);
    }

    @Override
    public long getSongCount() {
        return songRepository.count();
    }
}
