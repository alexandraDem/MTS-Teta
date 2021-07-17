package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import java.security.AccessControlContext

class MoviesAdapter(
    context: Context,
    private val moviesList: List<MovieDto>
): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    class MoviesViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        private val title: TextView = itemView.findViewById(R.id.film_title)
        private val description: TextView =  itemView.findViewById(R.id.film_description)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
        private val ageRestriction: TextView = itemView.findViewById(R.id.age_restriction)
        private val poster: ImageView = itemView.findViewById(R.id.film_poster)

        fun bind(movie: MovieDto){
            title.text = movie.title
            description.text = movie.description
            ratingBar.rating = movie.rateScore.toFloat()
            ageRestriction.text = movie.ageRestriction.toString() + "+"
            poster.load(movie.imageUrl)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MoviesViewHolder {
        return MoviesViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): MovieDto = moviesList[position]

    override fun getItemCount(): Int = moviesList.size
}