package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val URL = "http://newsapi.org/v2/top-headlines?" +
            "country=ru&" +
            "apiKey=c04702003e3e4cffa7f742d641757840"

    fun newnews(): String {

        var news = ""
        val request: Request = Request.Builder()
            .url(URL)
            .build()

        /*var response =  OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException?) {}

            override fun onResponse(call: Call?, response: Response) {
                news = JSONObject(response.body()!!.string()).getJSONArray("articles")
                    .getJSONObject((0..19).random()).getString("title")
                runOnUiThread {
                    newsTxt.text = news
                }
            }
        })*/

        var response =  OkHttpClient().newCall(request).execute()

        if(response.isSuccessful) {
            val responseBody = response.body()
            val fulljson = responseBody!!.string()
            if (fulljson != null)
                news = JSONObject(fulljson).getJSONArray("articles")
                    .getJSONObject((0..19).random()).getString("title")
        }
        return news
    }

    fun setTextNews(view: View) {
            newsTxt.text = newnews()
    }
}