package com.baileninformacion.videoteca.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baileninformacion.videoteca.databinding.ItemMovieBinding
import com.baileninformacion.videoteca.model.Movie
import kotlin.collections.ArrayList

class MoviesAdapter(private val listener: (Movie) -> Unit) : RecyclerView.Adapter<MoviesViewHolder>(){
    private var movieList = arrayListOf<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener{ listener(movie)}
    }
    fun refreshList(lista: ArrayList<Movie>){
        this.movieList.addAll(lista)
        notifyDataSetChanged()
    }

    fun filterByName(filteredList: List<Movie>){
        movieList.clear()
        movieList.addAll(filteredList)
        notifyDataSetChanged()
    }
    fun orderByName(){
        val sortedList = movieList.sortedBy { it.name }
        movieList.clear()
        movieList.addAll(sortedList)
        notifyDataSetChanged()
    }
    fun insertObject(){
        val item = Movie(13,"Prueba","Prueba","https://i.pinimg.com/564x/1d/7d/80/1d7d80e1ec3beb5d808d5d16fb757007.jpg",1972)
        movieList.add(0,item)
        notifyItemInserted(0)
    }

    fun modifyObject(){
        movieList[0].name = "ALGO"
        notifyItemChanged(0)
    }

    fun deleteObject(){
        movieList.removeAt(0)
        notifyItemRemoved(0)
    }
}