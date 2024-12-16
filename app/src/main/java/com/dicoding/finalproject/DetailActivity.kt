package com.dicoding.finalproject

import android.os.Build
import android.os.Bundle
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_TOUR = "key_tour"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)



        val dataTour = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Tour>(KEY_TOUR, Tour::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Tour>(KEY_TOUR)
        }

        dataTour?.let { tour ->
            val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
            val tvName: TextView = findViewById(R.id.tv_detail_name)
            val tvLocation: TextView = findViewById(R.id.tv_detail_location)
            val tvPrice: TextView = findViewById(R.id.tv_detail_price)
            val tvRating: TextView = findViewById(R.id.tv_detail_rating)
            val tvDescription: TextView = findViewById(R.id.tv_description)
            val tvDuration: TextView = findViewById(R.id.tv_detail_duration)

            imgPhoto.clipToOutline = true
            imgPhoto.setImageResource(tour.photo)
            tvName.text = tour.name
            tvLocation.text = tour.location
            tvPrice.text = tour.price + "/person"
            tvRating.text = tour.rating
            tvDescription.text = tour.description
            tvDuration.text = "Duration: " + tour.duration

        } ?: run {
            Toast.makeText(this, "Tour data is unavailable", Toast.LENGTH_SHORT).show()
        }





    }
}