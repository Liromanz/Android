package com.example.pract5_models.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UriImageModel {
    @SerializedName("articles")
    @Expose
    var article: Array<Articles>? = null
}

class Articles{
    @SerializedName("title")
    @Expose
    var title: String? = null
}