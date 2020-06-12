package com.example.movielist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.model.Movie
import com.example.movielist.service.RetrofitService
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MovieListAdapter
    lateinit var dialog: android.app.AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recycler_movies.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recycler_movies.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()
        val errorMsg: String = getString(R.string.loading_error)

        mService.getMovieList().enqueue(object : retrofit2.Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                Toast.makeText(baseContext, errorMsg, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                adapter = MovieListAdapter(response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recycler_movies.adapter = adapter
                dialog.dismiss()
            }


        })
    }
}

