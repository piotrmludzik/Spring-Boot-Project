package com.codecool.springbootproject.controller;

import com.codecool.springbootproject.model.Song;
import com.codecool.springbootproject.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    private ISongService service;

    @GetMapping("/songs/")
    public String findAllSongs(Model model) {
        var songs = (List<Song>) service.findAll();
        model.addAttribute("songs", songs); // przekazanie zmiennej z piosenkami do Thymeleaf
        return "songs";


    }

}
