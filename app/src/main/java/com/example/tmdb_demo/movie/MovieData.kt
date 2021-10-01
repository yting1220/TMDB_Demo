package com.example.tmdb_demo.movie

data class MovieData(
    val genres:String,
    val title:String,
    val score:String
)

val genresData = arrayListOf<MovieData>()
val nestedData = arrayListOf<MovieData>()