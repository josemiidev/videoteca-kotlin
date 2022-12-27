package com.baileninformacion.videoteca.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.baileninformacion.videoteca.Adapter.MoviesAdapter
import com.baileninformacion.videoteca.R
import com.baileninformacion.videoteca.databinding.ActivityMainBinding
import com.baileninformacion.videoteca.model.Movie
import com.baileninformacion.videoteca.utils.getJsonFromAssets
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var adapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MoviesAdapter(::onMovieClick)
        binding.listaPeliculas.adapter = adapter

        adapter.refreshList(getListFormJson())
    }
    private fun getListFormJson(): ArrayList<Movie> {
        val json = getJsonFromAssets("peliculas.json")
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        return ArrayList(movieList)
    }
    private fun onMovieClick(movie: Movie){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("movie",movie)
        startActivity(intent)
    }
}