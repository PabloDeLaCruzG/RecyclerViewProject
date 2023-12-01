package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.ApiHelper.Companion.userApi
import com.example.recyclerviewproject.databinding.ActivityRecyclerViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewActivity : ActivityMenu() {

    private lateinit var binding: ActivityRecyclerViewBinding
    data class Film (val titulo:String, val descripcion:String)
    private var filmList = ArrayList<Film>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)

        getFilmsApi()

    }

    fun filmClicked(film: Film, v: View) {
        filmList.remove(film)
        val pos = binding.myRecyclerView.getChildAdapterPosition(v)
        binding.myRecyclerView.adapter?.notifyItemRemoved(pos)
    }

    fun getFilmsApi() {

        val call = ApiHelper.userApi.getPeliculas()
        call.enqueue(object : Callback<List<Film>> {
            override fun onResponse(
                call: Call<List<Film>>,
                response: Response<List<Film>>
            ) {

                filmList = response.body() as ArrayList<Film>
                binding.myRecyclerView.adapter = AdapterFilms(filmList)
                {
                        film: Film, v: View -> filmClicked(film, v)
                }
            }

            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                Log.d("ErrorAPI", call.toString())
            }

        })

    }

}