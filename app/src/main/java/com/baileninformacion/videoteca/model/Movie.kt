package com.baileninformacion.videoteca.model

data class Movie(
    val id: Int,
    val name: String,
    val description: String,
    val cover: String
) : java.io.Serializable