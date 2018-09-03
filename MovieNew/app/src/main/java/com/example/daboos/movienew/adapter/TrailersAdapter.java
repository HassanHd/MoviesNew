package com.example.daboos.movienew.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daboos.movienew.R;
import com.example.daboos.movienew.callback.SetOnTrailerOnClackLisner;
import com.example.daboos.movienew.model.Trailers;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailersHolder> {
    private Context tcontext;
    private List<Trailers> List;
    private SetOnTrailerOnClackLisner lisner;

    public TrailersAdapter(Context tcontext, java.util.List<Trailers> list) {
        this.tcontext = tcontext;
        List = list;
    }

    public void setLisner(SetOnTrailerOnClackLisner lisner) {
        this.lisner = lisner;
    }

    @NonNull
    @Override
    public TrailersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(tcontext).inflate(R.layout.item_trailer, parent, false);
        return new TrailersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailersHolder holder, int position) {

        final Trailers trailers=List.get(position);

        holder.tvtral.setText(trailers.getName());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lisner.onTrailerCliced(trailers.getKey());

            }
        });


    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class TrailersHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgtra)
        ImageView imgtra;
        @BindView(R.id.tvtral)
        TextView tvtral;
        @BindView(R.id.root)
        LinearLayout root;
        public TrailersHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
