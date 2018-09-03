package com.example.daboos.movienew.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("results")
    private List<Movie> movies;
    @SerializedName("page")
    private int page;
    @SerializedName("total_pages")
    private int totalpages;
    @SerializedName("total_results")
    private int totalresults;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }

    public int getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(int totalresults) {
        this.totalresults = totalresults;
    }
}