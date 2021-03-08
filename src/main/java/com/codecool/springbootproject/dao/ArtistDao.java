package com.codecool.springbootproject.dao;

import com.codecool.springbootproject.model.SongModel;
import java.util.List;


public interface ArtistDao {

    List<SongModel> getArtistSongs(long id);

}
