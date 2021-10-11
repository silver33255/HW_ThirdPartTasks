package com.panaskin.cacheapp.dao;

import com.panaskin.cacheapp.entity.FilmSession;

public interface FilmSessionDao {
    void addFilmSession(FilmSession filmSession);
    void updateFilmSession(String sessionId, FilmSession filmSession);
    void deleteFilmSession(FilmSession filmSession);
    FilmSession getFilmSession(String sessionId);
}
