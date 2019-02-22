package com.example.chucknorrisjokes.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.chucknorrisjokes.Model.Batches.JokesList;
import com.example.chucknorrisjokes.Model.Object;
import com.example.chucknorrisjokes.Network.APIConnection;
import com.example.chucknorrisjokes.Network.APIRequest;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JokesViewModel extends ViewModel {

    private static final String TAG = "JokesViewModel";

    private MutableLiveData<Object> JokesList;
    private MutableLiveData<JokesList> allList;
    private MutableLiveData<Object> CharList;
    private MutableLiveData<Object> excludeList;

    public LiveData<Object> getJoke(){

        if (JokesList == null){
            JokesList = new MutableLiveData<Object>();
            loadJokes();
        }
        return JokesList;
    }

    public LiveData<JokesList> getAllJokes(){
        if(allList == null){
            allList = new MutableLiveData<JokesList>();
            loadAllJokes();
        }
        return allList;
    }

    public LiveData<Object> getChar(String fName,String lName){
        if(CharList == null){
            CharList = new MutableLiveData<Object>();
            loadChar(fName, lName);
        }
        return CharList;
    }

    public LiveData<Object> getExcludeJoke(){
        if(excludeList == null){
            excludeList = new MutableLiveData<Object>();
            loadExclude();
        }
        return excludeList;
    }

    private void loadJokes(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIRequest.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        APIConnection api_connection = retrofit.create(APIConnection.class);
        Call<Object> call = api_connection.getJoke();

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(@NotNull Call<Object> call, @NotNull Response<Object> response) {
                JokesList.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<Object> call, @NotNull Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());

            }
        });
    }

    private void loadChar(String firstName,String lastName){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIRequest.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        APIConnection api_connection = retrofit.create(APIConnection.class);
        Call<Object> call = api_connection.getChar(firstName,lastName);

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(@NotNull Call<Object> call, @NotNull Response<Object> response) {
                CharList.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<Object> call, @NotNull Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());

            }
        });
    }

    private void loadAllJokes(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIRequest.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        APIConnection api = retrofit.create(APIConnection.class);
        Call<JokesList> call = api.getAllJokes();

        call.enqueue(new Callback<JokesList>() {
            @Override
            public void onResponse(@NotNull Call<JokesList> call, @NotNull Response<JokesList> response) {
                allList.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<JokesList> call, @NotNull Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());

            }
        });
    }

    private void loadExclude(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIRequest.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        APIConnection API_connect = retrofit.create(APIConnection.class);
        Call<Object> call = API_connect.getExcludeJoke();

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(@NotNull Call<Object> call, @NotNull Response<Object> response) {
                excludeList.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<Object> call, @NotNull Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }


}
