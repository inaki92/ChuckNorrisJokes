package com.example.chucknorrisjokes.Model.Batches

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JokesList {

    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("value")
    @Expose
    var value: List<JokesC>? = null
}
