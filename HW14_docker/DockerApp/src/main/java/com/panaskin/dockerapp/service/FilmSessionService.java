package com.panaskin.dockerapp.service;

import com.panaskin.dockerapp.entity.FilmSession;

import java.util.List;
import java.util.Optional;

public interface FilmSessionService<T> {

    List<T> receiveAllSessions();
    Optional<T> receiveSessionById(Long id);
    void createFilmSession(String filmName);
    void deleteFilmSessionById(Long id);
}
