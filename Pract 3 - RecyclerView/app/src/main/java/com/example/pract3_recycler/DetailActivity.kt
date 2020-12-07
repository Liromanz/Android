package com.example.pract3_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getParcelableExtra<ItemOfList>("OBJECT_INTENT")

        Picasso.get().load(item!!.imageSrc).fit().into(_imageDetail)
        _imageTitle.text = item.imageTitle
        _imageDesc.text = item.imageDesc
    }
}
