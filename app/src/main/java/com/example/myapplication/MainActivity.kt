package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var moviesModel: MoviesModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie_details)

        val recycler = findViewById<RecyclerView>(R.id.movies_recycler)
        initDataSource()
        val movies: List<MovieDto> = moviesModel.getMovies()
        val adapter = MoviesAdapter(this, movies)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, MOVIES_PER_LINE)

//        recycler.addItemDecoration(MoviesItemDecorator(this, R.dimen.movies_recycler_view_side_margin, R.dimen.movies_recycler_view_top_margin))
//
//        fun onMoviesChanged(movies: List<MovieDto>){
//            adapter.movies = movies
//            adapter.notifyDataSetChanged()
//            adapter.notifyItemRemoved(2, "special")
//        }

    }

    private fun initDataSource() {
        moviesModel = MoviesModel(MoviesDataSourceImpl())
    }
}

private const val MOVIES_PER_LINE = 2