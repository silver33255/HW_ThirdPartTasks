package com.panaskin.cacheapp.service;

import com.panaskin.cacheapp.entity.Film;
import com.panaskin.cacheapp.entity.FilmSession;
import com.panaskin.cacheapp.entity.Ticket;

public interface FilmSessionService {
    void persistFilmSessionWithFilm(FilmSession filmSession, Film film);
    void addTicketsToFilmSessionPersist(FilmSession filmSession, Ticket... ticket);
}
