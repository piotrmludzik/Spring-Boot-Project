package com.codecool.springbootproject.repository;

import com.codecool.springbootproject.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Integer>{
}
