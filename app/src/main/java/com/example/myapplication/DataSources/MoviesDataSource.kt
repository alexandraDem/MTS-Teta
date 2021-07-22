package com.example.myapplication.DataSources

import com.example.myapplication.DTOs.MovieDto

interface MoviesDataSource {
    fun getMovies(): List<MovieDto>
}