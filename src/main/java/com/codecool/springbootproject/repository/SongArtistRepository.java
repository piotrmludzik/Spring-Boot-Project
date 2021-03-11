package com.codecool.springbootproject.repository;

import com.codecool.springbootproject.model.SongArtist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongArtistRepository extends CrudRepository<SongArtist, Integer> {
}
