package com.panaskin.dockerapp.service.impl;
import com.panaskin.dockerapp.entity.FilmSession;
import com.panaskin.dockerapp.repository.FilmSessionRepository;
import com.panaskin.dockerapp.service.FilmSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmSessionServiceImpl implements FilmSessionService<FilmSession> {

    @Autowired
    private FilmSessionRepository filmSessionRepository;

    @Override
    public List<FilmSession> receiveAllSessions() {
        return filmSessionRepository.findAll();
    };

    @Override
    public Optional<FilmSession> receiveSessionById(Long id) {
        return filmSessionRepository.findById(id);
    }

    @Override
    public void createFilmSession(String filmName) {
        FilmSession filmSession = new FilmSession();
        filmSession.setFilm(filmName);
        filmSessionRepository.save(filmSession);
    }

    @Override
    public void deleteFilmSessionById(Long id) {
        filmSessionRepository.deleteById(id);
    }
}
