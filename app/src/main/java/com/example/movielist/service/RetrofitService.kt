package com.example.movielist.service

import com.example.movielist.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET(value = "marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}