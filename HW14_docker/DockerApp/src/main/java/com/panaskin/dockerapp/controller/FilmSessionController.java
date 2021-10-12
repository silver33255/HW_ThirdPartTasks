package com.panaskin.dockerapp.controller;

import com.panaskin.dockerapp.entity.FilmSession;
import com.panaskin.dockerapp.exception.FilmSessionNotFoundException;
import com.panaskin.dockerapp.service.FilmSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/sessions")
public class FilmSessionController {

    @Autowired
    private final FilmSessionService<FilmSession> sessionService;

    @GetMapping
    List<FilmSession> receiveAllSessions() {
        return sessionService.receiveAllSessions();
    }

    @GetMapping("/{id}")
    FilmSession sessionById(@PathVariable("id") Long id) {
        return sessionService.receiveSessionById(id)
                .orElseThrow(() -> new FilmSessionNotFoundException(id));
    }

    @PostMapping("/{filmName}")
    public void createFilmSessionWithFilm(@PathVariable("filmName") String filmName){
        sessionService.createFilmSession(filmName);
    }

    @DeleteMapping("/{id}")
    public void deleteFilmSessionById(@PathVariable("id") Long id){
        sessionService.deleteFilmSessionById(id);
    }
}
