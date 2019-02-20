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

public class RandomJokeAdapter extends RecyclerView.Adapter<RandomJokeAdapter.RandomViewHolder> {

    private Context mCtx;
    private JokesList JokeList;

    public RandomJokeAdapter(Context mCtx, JokesList jokeList){
        this.mCtx = mCtx;
        this.JokeList = jokeList;
    }

    class RandomViewHolder extends RecyclerView.ViewHolder{

        TextView joke, id_joke;

        public RandomViewHolder(@NonNull View itemView) {
            super(itemView);

            joke = itemView.findViewById(R.id.joke);
            id_joke = itemView.findViewById(R.id.joke_id);
        }
    }


    @NonNull
    @Override
    public RandomJokeAdapter.RandomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.jokes_list_cards,viewGroup,false);
        return new RandomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomJokeAdapter.RandomViewHolder randomViewHolder, int i) {

        randomViewHolder.joke.setText(JokeList.getValue().get(i).getJoke());
        randomViewHolder.id_joke.setText(JokeList.getValue().get(i).getId());

    }

    @Override
    public int getItemCount() {
        return JokeList.getValue().size();
    }
}
