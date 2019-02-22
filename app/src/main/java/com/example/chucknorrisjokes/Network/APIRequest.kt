package com.example.chucknorrisjokes.Network

object APIRequest {

    const val BASE_URL = "https://api.icndb.com/"
    const val RDM_JOKES = "jokes/random"
    const val CHARACTER_CHANGED = "jokes/random?firstName=&amp;lastName="
    const val ALL_JOKES_URL = "jokes/random/20"
    const val EXCLUDE_EXPLICIT_URL = "jokes/random?exclude=[explicit]"
}
