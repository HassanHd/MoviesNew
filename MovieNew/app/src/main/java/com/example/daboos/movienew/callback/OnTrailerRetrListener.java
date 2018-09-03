package com.example.daboos.movienew.callback;

import com.example.daboos.movienew.model.Trailers;

import java.util.List;

public interface OnTrailerRetrListener {
    void onReterived(List<Trailers>trailersList);
    void OnError(String errormsg);
}
