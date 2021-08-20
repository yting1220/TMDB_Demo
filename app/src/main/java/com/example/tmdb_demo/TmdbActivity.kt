package com.example.tmdb_demo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.tmdb_demo.databinding.ActivityTmdbBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TmdbActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Tmdb"
    }

    private lateinit var binding: ActivityTmdbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmdbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, intent.getStringExtra("From").toString())

        // Bottom Navigation
        with(binding) {
            tmdbNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.navigation_movie -> {
                        Log.d(TAG, "MOVIE")
                        val manager = supportFragmentManager
                        val transaction = manager.beginTransaction()
                        val movieFragment = MovieFragment()
                        transaction.replace(R.id.fragmentHolder, movieFragment).commit()
                        transaction.addToBackStack(null)
                        return@setOnItemSelectedListener true
                    }
                    R.id.navigation_drama -> {
                        Log.d(TAG, "Drama")
                        val manager = supportFragmentManager
                        val transaction = manager.beginTransaction()
                        val dramaFragment = DramaFragment()
                        transaction.replace(R.id.fragmentHolder, dramaFragment).commit()
                        transaction.addToBackStack(null)
                        return@setOnItemSelectedListener true
                    }
                }
                false
            }
        }
    }

    // Button on ActionBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}