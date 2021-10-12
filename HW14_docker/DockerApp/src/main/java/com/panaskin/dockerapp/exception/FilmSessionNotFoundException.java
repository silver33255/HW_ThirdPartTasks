package com.panaskin.dockerapp.exception;

public class FilmSessionNotFoundException extends RuntimeException{

    public FilmSessionNotFoundException(long id){
        super("Couldn't found film session by id: " + id);
    }
}
