package com.example.pract5_models

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pract5_models.Models.UriImageModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAPI.setOnClickListener {
            sendNetworkRequest()
        }
    }

    fun sendNetworkRequest(){
        val builder = Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        val apiInterface: ApiInterface = retrofit.create<ApiInterface>(ApiInterface::class.java)
        val call : Call<UriImageModel> = apiInterface.getTitle()

        call.enqueue(object : Callback<UriImageModel> {
            override fun onFailure(call: Call<UriImageModel>, t: Throwable) {}

            override fun onResponse(call: Call<UriImageModel>, response: Response<UriImageModel>) {
                txtView.text = response.body()!!.article!!.toString()
            }
        })
    }
}