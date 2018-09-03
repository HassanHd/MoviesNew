package com.example.daboos.movienew.util;

import com.appizona.yehiahd.fastsave.FastSave;
import com.example.daboos.movienew.model.Movie;

import java.util.List;

public class Util {
    public static boolean isFavorit(int id) {
        List<Movie> movies = FastSave.getInstance().getObjectsList(Constant.FAV_MOVIES, Movie.class);
        for (Movie m : movies) {
            if (m.getId() == id) {
                return true;
            }

        }
        return false;


    }
public static void removeFromFav(int id){
    List<Movie> movies = FastSave.getInstance().getObjectsList(Constant.FAV_MOVIES, Movie.class);
    for (int i=0;i<movies.size();i++){
        if (movies.get(i).getId()==id){
            movies.remove(i);
            FastSave.getInstance().saveObjectsList(Constant.FAV_MOVIES,movies);
        }
    }


}
public static void addFavorite(Movie mMovie){
    List<Movie>movies= FastSave.getInstance().getObjectsList(Constant.FAV_MOVIES,Movie.class);
    movies.add(mMovie);
    FastSave.getInstance().saveObjectsList(Constant.FAV_MOVIES,movies);
}
}
