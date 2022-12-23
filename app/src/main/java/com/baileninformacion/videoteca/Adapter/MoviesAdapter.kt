package com.baileninformacion.videoteca.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baileninformacion.videoteca.databinding.ItemMovieBinding
import com.baileninformacion.videoteca.model.Movie

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>(){
    private val movieList = arrayListOf<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }
    fun refreshList(lista: ArrayList<Movie>){
        this.movieList.addAll(lista)
        notifyDataSetChanged()
    }
}