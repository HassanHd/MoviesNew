package com.example.daboos.movienew.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailersResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("results")
    private List<Trailers>trailers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Trailers> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailers> trailers) {
        this.trailers = trailers;
    }
}
