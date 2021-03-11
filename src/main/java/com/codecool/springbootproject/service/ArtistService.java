package com.codecool.springbootproject.service;

import com.codecool.springbootproject.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {

    List<Artist> findAllArtists();
    Optional<Artist> getArtistById(int id);
    void deleteArtistById(int id);
    long getArtistCount();
}
