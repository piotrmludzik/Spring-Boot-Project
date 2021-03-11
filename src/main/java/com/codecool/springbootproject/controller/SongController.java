package com.codecool.springbootproject.controller;

import com.codecool.springbootproject.model.Song;
import com.codecool.springbootproject.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Controller
public class SongController {

    SongService service;

    @Autowired
    public SongController(SongService service) {
        this.service = service;
    }

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

    @RequestMapping("/addSongForm")
    public ModelAndView addSongForm() {
        return new ModelAndView("addSongForm", "song", new Song());
    }

    @RequestMapping(value="/addSongForm", method=RequestMethod.POST)
    public String handleSongForm(@Valid @ModelAttribute ("song") Song song, BindingResult bindingResult) throws SQLException {
        log.info("handleSongForm called");
//        if(bindingResult.hasErrors()){
//            log.info("inside bindingResult.hasErrors()");
//            return "addSongForm";
//        }
        log.info("id {}", song.getId());
        log.info("name {}", song.getName());
        log.info("date {}", song.getDate());
        log.info("duration {}", song.getDuration());
        service.addNewSong(song);
        log.info("song " + song.getName() + " added. It has an id " + song.getId());
        return "songs";
    }

}
