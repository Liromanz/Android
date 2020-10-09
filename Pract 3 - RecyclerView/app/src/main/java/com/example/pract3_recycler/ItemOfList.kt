package com.example.pract3_recycler

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemOfList(
    val imageSrc: String,
    val imageTitle: String,
    val imageDesc: String
) : Parcelable
