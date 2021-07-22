package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DTOs.MovieDto
import com.example.myapplication.DataSources.MoviesDataSourceImpl
import com.example.myapplication.Models.MoviesModel

class MainActivity : AppCompatActivity() {

    private lateinit var moviesModel: MoviesModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie_details)
    }

}

