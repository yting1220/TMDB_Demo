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

        Log.d(TAG, intent.getStringExtra("From").toString())

        val tmdbNavigation: BottomNavigationView = findViewById(R.id.tmdb_navigation)

        // Bottom Navigation
        tmdbNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_movie -> {
                    Log.d(TAG, "MOVIE")
                    val manager = supportFragmentManager
                    val transaction = manager.beginTransaction()
                    val movieFragment = MovieFragment()
                    transaction.replace(R.id.fragment_holder, movieFragment).commit()
                    transaction.addToBackStack(null)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_drama -> {
                    Log.d(TAG, "Drama")
                    val manager = supportFragmentManager
                    val transaction = manager.beginTransaction()
                    val dramaFragment = DramaFragment()
                    transaction.replace(R.id.fragment_holder, dramaFragment).commit()
                    transaction.addToBackStack(null)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }
}