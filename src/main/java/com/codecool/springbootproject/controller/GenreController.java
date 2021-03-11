package com.codecool.springbootproject.controller;

import com.codecool.springbootproject.model.Genre;
import com.codecool.springbootproject.service.GenreService;
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
public class GenreController {

    GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public String findAllGenres(Model model) {
        var genreCount = genreService.getGenreCount();
        var genres = (List<Genre>) genreService.findAllGenres();
        model.addAttribute("count", genreCount);
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

    @RequestMapping("/addGenre")
    public ModelAndView addGenreForm() {
        return new ModelAndView("addGenre", "genre", new Genre());
    }

    @RequestMapping(value="/addGenre", method= RequestMethod.POST)
    public String handleGenreForm(@Valid @ModelAttribute("genre") Genre genre, BindingResult bindingResult) throws SQLException {
        log.info("handleGenreForm called");
        if(bindingResult.hasErrors()){
            log.info("inside bindingResult.hasErrors()");
            return "addSongForm";
        }
        genreService.addNewGenre(genre);
        log.info("genre " + genre.getName() + " added. It has an id " + genre.getId());
        return "genres";
    }
}
