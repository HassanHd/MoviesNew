package com.example.daboos.movienew.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.appizona.yehiahd.fastsave.FastSave;
import com.example.daboos.movienew.R;
import com.example.daboos.movienew.adapter.MoviesAdapter;
import com.example.daboos.movienew.api.Networking;
import com.example.daboos.movienew.callback.OnMoviesRetreivalListener;
import com.example.daboos.movienew.model.Movie;
import com.example.daboos.movienew.model.MovieResponse;
import com.example.daboos.movienew.util.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.daboos.movienew.R.menu.menu_main;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


}
