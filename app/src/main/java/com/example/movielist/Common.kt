package com.example.movielist

import com.example.movielist.retrofit.RetrofitClient
import com.example.movielist.service.RetrofitService
import retrofit2.create

object Common {
    private const val BASE_URL = "http://simplifiedcoding.net/demos/"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)

}