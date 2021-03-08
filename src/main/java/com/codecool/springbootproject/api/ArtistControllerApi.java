package com.codecool.springbootproject.api;

import com.codecool.springbootproject.model.SongModel;
import com.codecool.springbootproject.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/artist-songs")
@RestController
public class ArtistControllerApi {

    private final ArtistService artistService;

    @Autowired
    public ArtistControllerApi(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping(path = "{id}")
    public  List<SongModel> getArtistSongs(@PathVariable("id") long id){
        return artistService.getArtistSongs(id);
    }

}
