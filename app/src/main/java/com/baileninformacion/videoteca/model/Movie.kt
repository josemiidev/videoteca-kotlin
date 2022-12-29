package com.baileninformacion.videoteca.model

data class Movie(
    val id: Int,
    var name: String,
    val description: String,
    val cover: String,
    val year : Int
) : java.io.Serializable