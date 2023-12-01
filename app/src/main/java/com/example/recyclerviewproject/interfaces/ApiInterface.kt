package com.example.recyclerviewproject.interfaces

import com.example.recyclerviewproject.RecyclerViewActivity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("/api/Pelicula")
    fun getPeliculas(): Call<List<RecyclerViewActivity.Film>>

    /*@POST("/api/add_pelicula")
    fun addPelicula(id:String, nombre:String, description:String)*/

}