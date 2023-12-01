package com.example.recyclerviewproject

import com.example.recyclerviewproject.interfaces.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiHelper {

    companion object {
        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val userApi = retrofit.create<ApiInterface>()
    }

}