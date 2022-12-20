package com.baileninformacion.videoteca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baileninformacion.videoteca.R
import com.baileninformacion.videoteca.model.Movie
import com.baileninformacion.videoteca.utils.getJsonFromAssets
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun getListFormJson(): ArrayList<Movie> {
        val json = getJsonFromAssets("movies.json")
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        return ArrayList(movieList)
    }
}