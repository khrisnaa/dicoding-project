package com.dicoding.finalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tour(
    val name: String,
    val location: String,
    val price: String,
    val duration: String,
    val rating: String,
    val description: String,
    val photo: Int
) : Parcelable
