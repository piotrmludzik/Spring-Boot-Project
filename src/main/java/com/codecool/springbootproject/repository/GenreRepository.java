package com.codecool.springbootproject.repository;

import com.codecool.springbootproject.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer>  {
}
