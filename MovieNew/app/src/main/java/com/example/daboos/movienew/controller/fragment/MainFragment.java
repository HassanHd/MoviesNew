package com.example.daboos.movienew.controller.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.appizona.yehiahd.fastsave.FastSave;
import com.example.daboos.movienew.R;
import com.example.daboos.movienew.adapter.MoviesAdapter;
import com.example.daboos.movienew.api.Networking;
import com.example.daboos.movienew.callback.OnMoviesRetreivalListener;
import com.example.daboos.movienew.controller.activity.MainActivity;
import com.example.daboos.movienew.model.Movie;
import com.example.daboos.movienew.util.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.progrespar_move)
    ProgressBar progresparMove;
    Unbinder unbinder;
    private MoviesAdapter adapter;
    private RecyclerView.LayoutManager mlayoutManager;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);

        mlayoutManager=new GridLayoutManager(getActivity(),2);
        recycler.setLayoutManager(mlayoutManager);
        getMovies(Constant.POPLUER_MOVIES_KEY);
        return view;
    }

    private void getMovies(String moviesType) {
        Networking.getMovies(moviesType,new OnMoviesRetreivalListener() {
            @Override
            public void onSucess(List<Movie> movies) {

                adapter=new MoviesAdapter(getActivity(),movies);
                recycler.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMasg) {
                Toast.makeText(getActivity(), errorMasg, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.populer:
                getMovies(Constant.POPLUER_MOVIES_KEY);
                return true;
            case R.id.top_rated:
                getMovies(Constant.TOP_RATED_MOVIES_KEY);
                return true;
            case R.id.favorite:
                List<Movie>movies= FastSave.getInstance().getObjectsList(Constant.FAV_MOVIES,Movie.class);
                adapter =new MoviesAdapter(getActivity(),movies);
                recycler.setAdapter(adapter);

                return true;
        }
        return false;
    }
}
