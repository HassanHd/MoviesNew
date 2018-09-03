package com.example.daboos.movienew.controller.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.daboos.movienew.R;
import com.example.daboos.movienew.adapter.TrailersAdapter;
import com.example.daboos.movienew.api.Networking;
import com.example.daboos.movienew.callback.OnTrailerRetrListener;
import com.example.daboos.movienew.callback.SetOnTrailerOnClackLisner;
import com.example.daboos.movienew.model.Trailers;
import com.example.daboos.movienew.util.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrailerActivity extends AppCompatActivity {

    @BindView(R.id.recyclertrailer)
    RecyclerView recyclertrailer;
    private RecyclerView.LayoutManager mlayoutManager;
    private TrailersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
mlayoutManager=new LinearLayoutManager(this);
recyclertrailer.setLayoutManager(mlayoutManager);
int id=getIntent().getExtras().getInt(Constant.MOVIE_ID);
        Networking.getTrailer(String.valueOf(id), new OnTrailerRetrListener() {
            @Override
            public void onReterived(List<Trailers> trailersList) {

                adapter=new TrailersAdapter(TrailerActivity.this,trailersList);
                adapter.setLisner(new SetOnTrailerOnClackLisner() {
                    @Override
                    public void onTrailerCliced(String key) {
watchYoutubeVideo(key);
                    }
                });
                recyclertrailer.setAdapter(adapter);


            }

            @Override
            public void OnError(String errormsg) {
                Toast.makeText(TrailerActivity.this, errormsg, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void watchYoutubeVideo( String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}
