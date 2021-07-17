package com.example.myapplication

class MoviesModel(private val moviesDataSource: MoviesDataSource) {
    fun getMovies() = moviesDataSource.getMovies()
}