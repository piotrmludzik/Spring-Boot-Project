package com.codecool.springbootproject.service;

import com.codecool.springbootproject.dao.ArtistDao;
import com.codecool.springbootproject.model.SongModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistDao artistDao;

    @Autowired
    public ArtistService(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }


    public List<SongModel> getArtistSongs(long id) {
        return artistDao.getArtistSongs(id);
    }
}
