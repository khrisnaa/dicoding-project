package com.dicoding.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvTours: RecyclerView
    private val list = ArrayList<Tour>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTours = findViewById(R.id.rv_tours)
        rvTours.setHasFixedSize(true)

        list.addAll(getListTours())
        showRecyclerList()
    }

    private fun getListTours(): ArrayList<Tour> {
        val dataNames = resources.getStringArray(R.array.tour_names)
        val dataLocations = resources.getStringArray(R.array.tour_locations)
        val dataPrices = resources.getStringArray(R.array.tour_prices)
        val dataDurations = resources.getStringArray(R.array.tour_durations)
        val dataRatings = resources.getStringArray(R.array.tour_ratings)
        val dataDescriptions = resources.getStringArray(R.array.tour_descriptions)
        val dataPhotos = resources.obtainTypedArray(R.array.tour_photos)

        val listTour = ArrayList<Tour>()
        for (i in dataNames.indices) {
            val tour = Tour(
                name = dataNames[i],
                location = dataLocations[i],
                price = dataPrices[i],
                duration = dataDurations[i],
                rating = dataRatings[i],
                description = dataDescriptions[i],
                photo = dataPhotos.getResourceId(i, -1)
            )
            listTour.add(tour)
        }

        return listTour
    }

    private fun showRecyclerList() {
        rvTours.layoutManager = LinearLayoutManager(this)
        val listTourAdapter = ListTourAdapter(list)
        rvTours.adapter = listTourAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val AboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(AboutIntent)
        return super.onOptionsItemSelected(item)
    }
}