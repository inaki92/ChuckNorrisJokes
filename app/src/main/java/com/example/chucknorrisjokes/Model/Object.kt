package com.example.chucknorrisjokes.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Object {

    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("value")
    @Expose
    var value: Jokes? = null
}
