package com.example.chucknorrisjokes.Model.Batches

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JokesC {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("joke")
    @Expose
    var joke: String? = null
    @SerializedName("categories")
    @Expose
    var categories: List<String>? = null
}
