package com.codecool.springbootproject.repository;

import com.codecool.springbootproject.model.SongAlbum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongAlbumRepository extends CrudRepository<SongAlbum, Integer> {
}
