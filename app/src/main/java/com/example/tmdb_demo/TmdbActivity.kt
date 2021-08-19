package com.example.tmdb_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView

class TmdbActivity : AppCompatActivity() {
    companion object {
        const val TAG = "Tmdb"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tmdb)

        val tmdbNavigation: BottomNavigationView = findViewById(R.id.tmdb_navigation)

        // Bottom Navigation
        tmdbNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_movie -> {
                    Log.e(TAG, "MOVIE")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_drama -> {
                    Log.e(TAG, "Drama")
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }
}