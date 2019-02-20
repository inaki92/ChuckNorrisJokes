package com.example.chucknorrisjokes.Network

import com.example.chucknorrisjokes.Model.Batches.JokesList
import com.example.chucknorrisjokes.Model.Object

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIConnection {

    @get:GET(APIRequest.RDM_JOKES)
    val joke: Call<Object>

    @get:GET(APIRequest.ALL_JOKES_URL)
    val allJokes: Call<JokesList>

    @GET(APIRequest.CHARACTER_CHANGED)
    fun getChar(@Query("firstName") newName: String, @Query("lastName") lastName: String): Call<Object>
}
