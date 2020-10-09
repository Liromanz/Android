package com.example.pract3_recycler

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var item : String = ""
    var suicide : ArrayList<ItemOfList> = ArrayList()
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("key", suicide)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val itemList = mutableListOf<ItemOfList>()
        suicide = savedInstanceState.getParcelableArrayList<ItemOfList>("key")!!
        for (mpt in suicide){
            itemList += mpt
        }

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(this, itemList) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("OBJECT_INTENT", it)
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf("Россия", "Америка", "Китай", "Бразилия", "Куба", "Гонконг", "Израель", "Литва", "Филиппины", "Саудовская аравия"))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        positionSpinner.adapter = adapter

        positionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                item = adapter.getItem(position).toString()
            }
        }
    }

    fun btnNews(view: View){
        _imageRecyclerView.adapter = null
        var country = ""
        notFoundTxt.visibility = View.GONE

        when {
            item == "Россия" -> country = "country=ru&"
            item == "Америка" -> country = "country=us&"
            item == "Китай" -> country = "country=cn&"
            item == "Бразилия" -> country = "country=br&"
            item == "Куба" -> country = "country=cu&"
            item == "Гонконг" -> country = "country=hk&"
            item == "Израель" -> country = "country=il&"
            item == "Литва" -> country = "country=lt&"
            item == "Филиппины" -> country = "country=ph&"
            item == "Саудовская аравия" -> country = "country=sa&"
        }

        var search = ""
        if (editText.text.toString() != "")
            search = "q="+editText.text.toString()+"&"

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        val imageList : List<ItemOfList> = jsonGetter("http://newsapi.org/v2/top-headlines?"+search+country+"apiKey=c04702003e3e4cffa7f742d641757840")

        if (imageList.isEmpty())
            notFoundTxt.visibility = View.VISIBLE
        else {
            val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = ItemAdapter(this, imageList) {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("OBJECT_INTENT", it)
                startActivity(intent)
            }
        }
    }

    private fun jsonGetter(url : String) : List<ItemOfList>{
        val imageList = mutableListOf<ItemOfList>()
        var newsTitle: String
        var newsImage: String
        var newsContent: String

        val request: Request = Request.Builder().url(url).build()

        val response = OkHttpClient().newCall(request).execute()
        if (response.isSuccessful){
            val resp = JSONObject(response.body()!!.string()).getJSONArray("articles")
            var i = 0

            while (i < resp.length()) {
                newsTitle = resp.getJSONObject(i).getString("title")
                newsImage = resp.getJSONObject(i).getString("urlToImage")
                newsContent = resp.getJSONObject(i).getString("description")
                imageList += ItemOfList(newsImage, newsTitle, newsContent)
                i++
            }
            for (mpt in imageList){
                suicide.add(mpt)
            }
        }
        return imageList
    }
}