package com.codecool.springbootproject.dao;

import com.codecool.springbootproject.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface SongRepository extends CrudRepository<Song, Integer>{

    List<Song> findById(long id);
    void deleteById(long id);

}
