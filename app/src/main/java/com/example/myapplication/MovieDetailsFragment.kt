package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DTOs.MovieDto
import com.example.myapplication.DataSources.MoviesDataSourceImpl
import com.example.myapplication.Models.MoviesModel

class MovieDetailsFragment : Fragment() {

    private lateinit var moviesModel: MoviesModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)
        return view
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_movie_details)
//
//    }

    override fun onStart() {
        super.onStart()

        initDataSource()
        initViews()
    }


    private fun initViews() {

        val recycler = view?.findViewById<RecyclerView>(R.id.movies_recycler)
        val movies: List<MovieDto> = moviesModel.getMovies()
        val adapter = MoviesAdapter(requireContext(), movies, this::adapterMovieListener)
        recycler?.adapter = adapter
        recycler?.layoutManager = GridLayoutManager(requireContext(), MOVIES_PER_LINE)

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
            else -> Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }
}

private const val MOVIES_PER_LINE = 2