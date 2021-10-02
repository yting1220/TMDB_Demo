package com.example.tmdb_demo.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb_demo.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 加載 fragment 的 layout
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root.apply {
            // Get Data and then Display it

            val genresList = listOf("Popular", "Now playing", "Upcoming", "Top rated")

            for (i in genresList) {
                genresData.add(MovieData(i,"",""))
            }
            for (i in 1..5) {
                nestedData.add(MovieData("", "電影$i",i.toString()))
            }
            val adapter = MovieAdapter()
            adapter.updateList(genresData)
            binding.verticalMovies.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            binding.verticalMovies.adapter = adapter
        }
    }
}