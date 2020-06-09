package com.example.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.model.Movie
import com.example.movielist.service.RetrofitService
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

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

    private fun getAllMovieList(){
        dialog.show()

        mService.getMovieList().enqueue(object : retrofit2.Callback<MutableList<Movie>>{
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
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

