package com.example.daboos.movienew.controller.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daboos.movienew.R;
import com.example.daboos.movienew.controller.activity.TrailerActivity;
import com.example.daboos.movienew.model.Movie;
import com.example.daboos.movienew.util.Constant;
import com.example.daboos.movienew.util.Util;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.imgcaver)
    ImageView imgcaver;
    @BindView(R.id.img_v_poster)
    ImageView imgVPoster;
    @BindView(R.id.tv_movi_Titel)
    TextView tvMoviTitel;
    @BindView(R.id.tvRating)
    TextView tvRating;
    @BindView(R.id.tv_movidate)
    TextView tvMovidate;
    @BindView(R.id.fav_but)
    FloatingActionButton favBut;
    @BindView(R.id.movidscraption)
    TextView movidscraption;
    @BindView(R.id.btn_tralr)
    Button btnTralr;
    Unbinder unbinder;
    private Movie mMovie;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        Movie movie=getActivity().getIntent().getExtras().getParcelable(Constant.MOVIE_ExTRA);
        mMovie=movie;
        boolean isFav= Util.isFavorit(mMovie.getId());
        if (isFav){
            favBut.setImageResource(R.drawable.stars);
        }
        else {
            favBut.setImageResource(R.drawable.starw);
        }
        tvMoviTitel.setText(movie.getTitle());
        tvMovidate.setText(movie.getRelease_date());
        tvRating.setText(String.valueOf(movie.getVote_average()));
        movidscraption.setText(movie.getOverview());

        Picasso.get()
                .load(Constant.BASE_IMG_URL+movie.getBackdrop_path())
                .into(imgcaver);
        Picasso.get()
                .load(Constant.BASE_IMG_URL+movie.getPoster_path())
                .into(imgVPoster);
        favBut.setOnClickListener(this);
        btnTralr.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fav_but:
                boolean isFav= Util.isFavorit(mMovie.getId());
                if (isFav){
                    Util.removeFromFav(mMovie.getId());
                    favBut.setImageResource(R.drawable.starw);
                }
                else {
                    Util.addFavorite(mMovie);

                    favBut.setImageResource(R.drawable.stars);
                }
                break;
            case R.id.btn_tralr:
                Intent intent=new Intent(getActivity(), TrailerActivity.class);
                intent.putExtra(Constant.MOVIE_ID,mMovie.getId());
                startActivity(intent);
                break;
        }


    }
}
