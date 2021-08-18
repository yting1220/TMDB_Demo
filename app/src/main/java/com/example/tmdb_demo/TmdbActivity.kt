package com.example.tmdb_demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_tmdb.*

class TmdbActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Tmdb"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tmdb)

        // Bottom Navigation
        tmdb_navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_movie -> {
                    Log.e(TAG, "MOVIE")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_drama -> {
                    Log.e(TAG, "MOVIE")
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

    }
}