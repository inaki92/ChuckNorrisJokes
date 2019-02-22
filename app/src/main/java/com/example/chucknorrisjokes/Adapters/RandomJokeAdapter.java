package com.example.chucknorrisjokes.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chucknorrisjokes.Model.Batches.JokesList;
import com.example.chucknorrisjokes.R;

public class RandomJokeAdapter extends RecyclerView.Adapter<RandomJokeAdapter.JokesViewHolder> {

    private static final String TAG = "RandomJokeAdapter";

    private Context mCtx;
    private JokesList JokeList;

    public RandomJokeAdapter(Context mCtx, JokesList jokeList) {
        this.mCtx = mCtx;
        this.JokeList = jokeList;
    }

    static class JokesViewHolder extends RecyclerView.ViewHolder{

        TextView joke, id_joke;

        JokesViewHolder(@NonNull View itemView) {
            super(itemView);

            joke = itemView.findViewById(R.id.joke);
            id_joke = itemView.findViewById(R.id.joke_id);
        }
    }

    @NonNull
    @Override
    public JokesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.jokes_list_cards,viewGroup,false);
        return new JokesViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull JokesViewHolder viewHolder, int i) {

        viewHolder.joke.setText(JokeList.getValue().get(i).getJoke());
        viewHolder.id_joke.setText(JokeList.getValue().get(i).getId());
    }

    @Override
    public int getItemCount() {
        return JokeList.getValue().size();
    }
}
