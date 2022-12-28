package com.baileninformacion.videoteca.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.baileninformacion.videoteca.Adapter.MoviesAdapter
import com.baileninformacion.videoteca.databinding.ActivityMainBinding
import com.baileninformacion.videoteca.model.Movie
import com.baileninformacion.videoteca.utils.getJsonFromAssets
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var adapter: MoviesAdapter

    private val copyList = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MoviesAdapter(::onMovieClick)
        binding.listaPeliculas.adapter = adapter

        adapter.refreshList(getListFormJson())

        binding.barraBusqueda.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                //AL CAMBIAR EL TEXTO DE LA BARRA
                newText?.let {
                    val filteredList = copyList.filter { it.name.toLowerCase(Locale.getDefault()).contains(newText) }
                    adapter.filterByName(filteredList)
                }
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                //CUANDO LE DAMOS A LA LUPA

                return false
            }
        })
    }
    private fun getListFormJson(): ArrayList<Movie> {
        val json = getJsonFromAssets("peliculas.json")
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        copyList.addAll(movieList)
        return ArrayList(movieList)
    }
    private fun onMovieClick(movie: Movie){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("movie",movie)
        startActivity(intent)
    }
}