package com.example.tmdb_demo.movie

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb_demo.R

class MovieAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var emptyList = arrayListOf<MovieData>()

    inner class MovieAdapterViewHolder(itemView:View)
        :RecyclerView.ViewHolder(itemView){
        val dataView: TextView = itemView.findViewById(R.id.text_movie_genres)
    }

    inner class NestedViewHolder(itemView:View)
        :RecyclerView.ViewHolder(itemView){
        val nestedView: RecyclerView = itemView.findViewById(R.id.recyclerview_Nested)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // 建立 ViewHolder 的地方，如果有同時支援多種 layout 的需求，
        // 可以複寫 getItemViewType function，
        // 這個 function 就可以拿到不同的 viewType 以供我們識別
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_movie,parent,false)
        val adapter = MovieNestedAdapter()
        adapter.updateList(nestedData)
        //nestedView.adapter的layout已經在xml定義
        NestedViewHolder(itemView).nestedView.adapter = adapter

        return MovieAdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        // 回傳整個 Adapter 包含幾筆資料
        return emptyList.size
    }

    //更新資料
    fun updateList(list:ArrayList<MovieData>){
        emptyList = list
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 因為 ViewHolder 會重複使用，
        // 我們要在這個 function 依據 position
        // 把正確的資料跟 ViewHolder 綁定在一起
        when(holder){
            is MovieAdapterViewHolder->{
                holder.dataView.text = emptyList[position].genres
                holder.itemView.setOnClickListener {
                    Toast.makeText(it.context, "Item $position is clicked.", Toast.LENGTH_SHORT).show()
                }
            }
            is NestedViewHolder->{
            }
        }
    }
}

