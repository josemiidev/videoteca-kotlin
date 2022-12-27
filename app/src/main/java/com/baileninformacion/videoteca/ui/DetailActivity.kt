package com.baileninformacion.videoteca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baileninformacion.videoteca.R
import com.baileninformacion.videoteca.databinding.ActivityDetailBinding
import com.baileninformacion.videoteca.model.Movie
import com.baileninformacion.videoteca.utils.loadImage

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private var movie : Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recogerPelicula()
        renderUi()
    }

    private fun recogerPelicula(){
        movie = intent.getSerializableExtra("movie") as Movie?
    }

    private fun renderUi(){
        binding.detailName.text = movie?.name
        binding.detailDescription.text = movie?.description
        movie?.cover?.let{ mCover ->
            binding.detailImage.loadImage(mCover)
        }
    }
}