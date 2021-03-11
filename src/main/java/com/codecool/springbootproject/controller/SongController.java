package com.codecool.springbootproject.controller;

import com.codecool.springbootproject.model.Song;
import com.codecool.springbootproject.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class SongController {

    @Autowired
    private SongService service;

    @GetMapping("/songs")
    public String findAllSongs(Model model) {
        var songs = (List<Song>) service.findAllSongs();
        var songCount = songs.size();
        model.addAttribute("count", songCount);
        model.addAttribute("songs", songs);
        log.info("findAllSongs called");

        return "songs";
    }

    @GetMapping("/delete/{id}")
    public String deleteSongById(@PathVariable("id") int id, Model model) {
        var song = service.getSongById(id);
        model.addAttribute("song", song.get().getName());
        service.deleteSongById(id);
        log.info("deleteSongById " + id + " called");

        return "deleteSong";
    }

    @GetMapping("/addSongForm")
    public String addSongForm() {
        return "addSongForm";
    }

}
