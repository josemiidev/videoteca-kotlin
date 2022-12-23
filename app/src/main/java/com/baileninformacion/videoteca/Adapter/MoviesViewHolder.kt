package com.baileninformacion.videoteca.Adapter

import androidx.recyclerview.widget.RecyclerView
import com.baileninformacion.videoteca.databinding.ItemMovieBinding
import com.baileninformacion.videoteca.model.Movie
import com.baileninformacion.videoteca.utils.loadImage

class MoviesViewHolder(private val itemBinding: ItemMovieBinding) :RecyclerView.ViewHolder(itemBinding.root){
    fun bind(movie: Movie){
        itemBinding.movieTitle.text = movie.name
        movie.cover?.let {
            itemBinding.movieCover.loadImage(movie.cover)
        }
    }
}