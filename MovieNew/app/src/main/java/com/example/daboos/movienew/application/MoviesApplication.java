package com.example.daboos.movienew.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.appizona.yehiahd.fastsave.FastSave;
import com.example.daboos.movienew.util.Constant;

import java.util.ArrayList;

public class MoviesApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        FastSave.init(getApplicationContext());
        if (!FastSave.getInstance().isKeyExists(Constant.FAV_MOVIES))
        FastSave.getInstance().saveObject(Constant.FAV_MOVIES,new ArrayList<>());


    }
}
