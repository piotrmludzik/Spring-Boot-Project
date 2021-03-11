package com.codecool.springbootproject.service;

import com.codecool.springbootproject.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    List<Genre> findAllGenres();
    Optional<Genre> getGenreById(int id);
    void deleteGenreById(int id);
    void addNewGenre(Genre genre);
    long getGenreCount();
}
