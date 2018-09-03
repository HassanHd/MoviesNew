package com.example.daboos.movienew.controller.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.appizona.yehiahd.fastsave.FastSave;
import com.example.daboos.movienew.R;
import com.example.daboos.movienew.model.Movie;
import com.example.daboos.movienew.util.Constant;
import com.example.daboos.movienew.util.Util;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);


    }


}
