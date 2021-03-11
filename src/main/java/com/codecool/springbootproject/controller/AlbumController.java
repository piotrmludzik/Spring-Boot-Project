package com.codecool.springbootproject.controller;

import com.codecool.springbootproject.model.Album;
import com.codecool.springbootproject.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class AlbumController {

    @Autowired
    private AlbumService service;

    @GetMapping("/albums")
    public String findAllAlbums(Model model) {
        var albums = (List<Album>) service.findAllAlbums();
        model.addAttribute("albums", albums);
        log.info("findAllAlbums called");

        return "albums";
    }

    @GetMapping("/deleteAlbum/{id}")
    public String deleteSongById(@PathVariable("id") int id, Model model) {
        var album = service.getAlbumById(id);
        model.addAttribute("album", album.get().getName());
        service.deleteAlbumById(id);
        log.info("deleteAlbumById " + id + " called");

        return "deleteAlbum";
    }

    @GetMapping("/addAlbum")
    public String addAlbum() {

        return "addAlbum";
    }
}
