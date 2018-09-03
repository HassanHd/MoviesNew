package com.example.daboos.movienew.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.daboos.movienew.R;
import com.example.daboos.movienew.controller.activity.DetailActivity;
import com.example.daboos.movienew.model.Movie;
import com.example.daboos.movienew.util.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {
    private Context mcontext;
    private List<Movie> list;

    public MoviesAdapter(Context mcontext, List<Movie> list) {
        this.mcontext = mcontext;
        this.list = list;
    }

    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mcontext).inflate(R.layout.item_movie, parent, false);
        return new MoviesHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder holder, int position) {

final Movie movie=list.get(position);
        Picasso.get()
                .load(Constant.BASE_IMG_URL +movie.getPoster_path())
                .error(R.drawable.hhh)
                .into(holder.imgCardMove);
        holder.CardMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, DetailActivity.class);
                intent.putExtra(Constant.MOVIE_ExTRA,movie);
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MoviesHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgCardMove)
        ImageView imgCardMove;
        @BindView(R.id.CardMove)
        CardView CardMove;

        public MoviesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
