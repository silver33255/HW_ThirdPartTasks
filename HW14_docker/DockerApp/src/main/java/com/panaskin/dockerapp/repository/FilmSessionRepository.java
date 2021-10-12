package com.panaskin.dockerapp.repository;

import com.panaskin.dockerapp.entity.FilmSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmSessionRepository extends JpaRepository<FilmSession, Long> {
}
