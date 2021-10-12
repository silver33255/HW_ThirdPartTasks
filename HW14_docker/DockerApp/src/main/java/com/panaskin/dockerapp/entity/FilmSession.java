package com.panaskin.dockerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@NoArgsConstructor
@Data
@Entity
@Table(name = "film_session")
public class FilmSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String film;
}
