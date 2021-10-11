package com.panaskin.cacheapp.dao;

import com.panaskin.cacheapp.AbstractIntegrationTest;
import com.panaskin.cacheapp.entity.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmDaoIT extends AbstractIntegrationTest {
    @Autowired
    private FilmDao filmDao;

    @Test
    public void shouldCreateFilm(){
        Film film = new Film();
        film.setFilmName("Test film");
        filmDao.addFilm(film);
        Assertions.assertEquals(filmDao.getFilm(film.getUuid().toString()), film);
    }

    @Test
    public void shouldDeleteFilm(){
        Film film = new Film();
        film.setFilmName("Test film");
        filmDao.addFilm(film);
        Assertions.assertNotNull(filmDao.getFilm(film.getUuid().toString()));
        filmDao.deleteFilm(film);
        Assertions.assertNull(filmDao.getFilm(film.getUuid().toString()));
    }

    @Test
    public void shouldUpdateFilm(){
        Film film = new Film();
        film.setFilmName("Test film");
        filmDao.addFilm(film);
        Film givenValue = filmDao.getFilm(film.getUuid().toString());
        film.setFilmName("Updated film");
        filmDao.updateFilm(givenValue.getUuid().toString(), film);
        Film updatedFilm = filmDao.getFilm(givenValue.getUuid().toString());
        Assertions.assertEquals(updatedFilm.getFilmName(), "Updated film");
    }
}
