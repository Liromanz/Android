package com.example.pract5_models.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Title{
    @SerializedName("title")
    @Expose
    var title: String? = null
}