package com.example.myapplication.Models

import com.example.myapplication.DataSources.MoviesDataSource

class MoviesModel(private val moviesDataSource: MoviesDataSource) {
    fun getMovies() = moviesDataSource.getMovies()
}