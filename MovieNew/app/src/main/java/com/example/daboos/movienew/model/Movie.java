package com.example.daboos.movienew.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable{
    private double vote_average;

    private String backdrop_path;

    private String adult;

    private int id;

    private String title;

    private String overview;

    private String original_language;

    private String[] genre_ids;

    private String release_date;

    private String original_title;

    private String vote_count;

    private String poster_path;

    private String video;

    private double popularity;

    protected Movie(Parcel in) {
        vote_average = in.readDouble();
        backdrop_path = in.readString();
        adult = in.readString();
        id = in.readInt();
        title = in.readString();
        overview = in.readString();
        original_language = in.readString();
        genre_ids = in.createStringArray();
        release_date = in.readString();
        original_title = in.readString();
        vote_count = in.readString();
        poster_path = in.readString();
        video = in.readString();
        popularity = in.readDouble();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(String[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(vote_average);
        dest.writeString(backdrop_path);
        dest.writeString(adult);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(original_language);
        dest.writeStringArray(genre_ids);
        dest.writeString(release_date);
        dest.writeString(original_title);
        dest.writeString(vote_count);
        dest.writeString(poster_path);
        dest.writeString(video);
        dest.writeDouble(popularity);
    }
}
