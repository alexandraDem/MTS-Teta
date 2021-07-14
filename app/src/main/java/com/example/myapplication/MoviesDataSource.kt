package com.example.myapplication

interface MoviesDataSource {
    fun getMovies(): List<MovieDto>
}