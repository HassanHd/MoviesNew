package com.example.daboos.movienew.api;

import android.view.View;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.daboos.movienew.adapter.MoviesAdapter;
import com.example.daboos.movienew.callback.OnMoviesRetreivalListener;
import com.example.daboos.movienew.callback.OnTrailerRetrListener;
import com.example.daboos.movienew.controller.activity.MainActivity;
import com.example.daboos.movienew.model.MovieResponse;
import com.example.daboos.movienew.model.TrailersResponse;
import com.example.daboos.movienew.util.Constant;

public class Networking {
    public static void getMovies(String moviesType,final OnMoviesRetreivalListener listener){
        AndroidNetworking.get(Constant.BASE_URL+moviesType)
                .addQueryParameter(Constant.API_key,Constant.API_VAL)
                .addQueryParameter(Constant.PAGE_KEY,"1")
                .build()
                .getAsObject(MovieResponse.class, new ParsedRequestListener<MovieResponse>() {
                    @Override
                    public void onResponse(MovieResponse response) {

                        listener.onSucess(response.getMovies());
                    }

                    @Override
                    public void onError(ANError anError) {
                        listener.onError(anError.getErrorDetail());
                    }
                });

    }
    public static void getTrailer(String movieID, final OnTrailerRetrListener listener){
        AndroidNetworking.get(Constant.BASE_URL+"{movie_id}"+Constant.VIDEOS)
                .addPathParameter("movie_id",movieID)
        .addQueryParameter(Constant.API_key,Constant.API_VAL)
                .build()
                .getAsObject(TrailersResponse.class, new ParsedRequestListener<TrailersResponse>() {

                    @Override
                    public void onResponse(TrailersResponse response) {

                        listener.onReterived(response.getTrailers());


                    }

                    @Override
                    public void onError(ANError anError) {

                        listener.OnError(anError.getErrorDetail());
                    }
                });
    }
}
