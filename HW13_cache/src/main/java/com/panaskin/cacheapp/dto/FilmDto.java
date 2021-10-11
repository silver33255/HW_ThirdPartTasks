package com.panaskin.cacheapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FilmDto {
    private UUID id;
    private String filmName;
}
