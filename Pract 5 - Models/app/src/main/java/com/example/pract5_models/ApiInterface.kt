package com.example.pract5_models

import retrofit2.http.GET
import com.example.pract5_models.Models.UriImageModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @GET("top-headlines?country=ru&apiKey=c04702003e3e4cffa7f742d641757840")
    fun getTitle(): Call<UriImageModel>
}