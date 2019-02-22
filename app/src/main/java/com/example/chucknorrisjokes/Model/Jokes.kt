package com.example.chucknorrisjokes.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Jokes {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("joke")
    @Expose
    var joke: String? = null
    @SerializedName("categories")
    @Expose
    var categories: List<String>? = null

}
