package com.example.movielist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieListAdapter(private val movieList: MutableList<Movie>):
    RecyclerView.Adapter<MovieListAdapter.MyHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.movie_item, p0, false)
        )
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        p0.bind(movieList[p1])
    }

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val movieImage = itemView.movie_image
        val movieName = itemView.movie_title
        val movieSeries = itemView.movie_series
        val movieAuthor = itemView.author

        fun bind(movie: Movie){
            Picasso.get().load(movie.imageurl).into(movieImage)
            movieName.text = movie.name
            movieAuthor.text = movie.createdby
            movieSeries.text = movie.team
        }
    }


}