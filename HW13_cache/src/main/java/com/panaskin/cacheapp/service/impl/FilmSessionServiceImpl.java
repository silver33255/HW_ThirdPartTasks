package com.panaskin.cacheapp.service.impl;

import com.panaskin.cacheapp.dao.FilmDao;
import com.panaskin.cacheapp.dao.FilmSessionDao;
import com.panaskin.cacheapp.dao.TicketDao;
import com.panaskin.cacheapp.entity.Film;
import com.panaskin.cacheapp.entity.FilmSession;
import com.panaskin.cacheapp.entity.Ticket;
import com.panaskin.cacheapp.service.FilmSessionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class FilmSessionServiceImpl implements FilmSessionService {
    @Autowired
    private FilmSessionDao filmSessionDao;

    @Autowired
    private FilmDao filmDao;

    @Autowired
    private TicketDao ticketDao;


    @Override
    public void persistFilmSessionWithFilm(FilmSession filmSession, Film film) {
        filmSession.setFilm(film);
        filmSessionDao.addFilmSession(filmSession);
    }

    @Override
    public void addTicketsToFilmSessionPersist(FilmSession filmSession, Ticket... tickets) {
        List<Ticket> filmSessionTickets = filmSession.getTickets();
        filmSessionTickets.addAll(Arrays.asList(tickets));
        for (Ticket ticket : filmSessionTickets) {
            ticket.setFilmSession(filmSession);
        }
        filmSessionDao.addFilmSession(filmSession);
    }
}
