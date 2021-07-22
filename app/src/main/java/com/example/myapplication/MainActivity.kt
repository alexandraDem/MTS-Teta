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

    override fun onStart() {
        super.onStart()

        initDataSource()
        initViews()
    }


    private fun initViews() {

        val recycler = findViewById<RecyclerView>(R.id.movies_recycler)
        val movies: List<MovieDto> = moviesModel.getMovies()
        val adapter = MoviesAdapter(this, movies, this::adapterMovieListener)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, MOVIES_PER_LINE)

    }

    private fun initDataSource() {
        moviesModel = MoviesModel(MoviesDataSourceImpl())
    }

    // make a message after click on movie item
    private fun adapterMovieListener(item: MovieDto) {
        showToast(item.title)
    }

    // show a floating message
    private fun showToast(message: String?) {
        when {
            message.isNullOrEmpty() -> {
                showToast("Пустое сообщение")
            }
            else -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}

private const val MOVIES_PER_LINE = 2