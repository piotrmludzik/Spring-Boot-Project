package com.codecool.springbootproject.repository;

import com.codecool.springbootproject.model.SongGenre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongGenreRepository extends CrudRepository<SongGenre, Integer> {
}
