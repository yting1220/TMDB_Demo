package com.example.tmdb_demo.Utils

import com.example.tmdb_demo.DataResponse.MoviePopularResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitMovie {
    //靜態方法。類的伴隨對象。
    companion object {
        fun getRrtrofit(): RetrofitMovie? {
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitMovie::class.java)
        }
    }
    @GET("popular")
    fun getpopmovie(
        @Query("api_key") api_key: String="affcd470da3f0ef01b930fad1a75d1ed",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): Call<MoviePopularResponse>
}