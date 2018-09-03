package com.example.daboos.movienew.callback;

import com.example.daboos.movienew.model.Movie;

import java.util.List;

public interface OnMoviesRetreivalListener {
    void onSucess(List<Movie>movies);
    void onError(String errorMasg);
}
