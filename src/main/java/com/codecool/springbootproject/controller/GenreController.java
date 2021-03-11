package com.codecool.springbootproject.controller;

import com.codecool.springbootproject.model.Genre;
import com.codecool.springbootproject.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public String findAllGenres(Model model) {
        var genres = (List<Genre>) genreService.findAllGenres();
        model.addAttribute("genres", genres);
        log.info("findAllGenres called");

        return "genres";
    }

    @GetMapping("/deleteGenre/{id}")
    public String deleteGenreById(@PathVariable("id") int id, Model model) {
        var genre = genreService.getGenreById(id);
        model.addAttribute("genre", genre.get().getName());
        genreService.deleteGenreById(id);
        log.info("deleteGenreById " + id + " called");

        return "deleteGenre";
    }

    @GetMapping("/addGenre")
    public String addGenre() {

        return "addGenre";
    }
}
