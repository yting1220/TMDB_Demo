package com.example.tmdb_demo.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb_demo.R

class MovieNestedAdapter: RecyclerView.Adapter<MovieNestedAdapter.mViewHolder>() {

    inner class mViewHolder(itemView:View)
        :RecyclerView.ViewHolder(itemView){
        val textTitle: TextView = itemView.findViewById(R.id.text_movie_title)
        val textScore: TextView = itemView.findViewById(R.id.text_movie_score)

        fun bind(item:MovieData){
            textTitle.text = item.title
            textScore.text = item.score
        }
    }

    var localList = arrayListOf<MovieData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        // 建立 ViewHolder 的地方，如果有同時支援多種 layout 的需求，
        // 可以複寫 getItemViewType function，
        // 這個 function 就可以拿到不同的 viewType 以供我們識別
        return mViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_movie_nested,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        // 回傳整個 Adapter 包含幾筆資料
        return localList.size
    }

    //更新資料
    fun updateList(list:ArrayList<MovieData>){
        localList = list
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        // 因為 ViewHolder 會重複使用，
        // 我們要在這個 function 依據 position
        // 把正確的資料跟 ViewHolder 綁定在一起
        holder.bind(localList[position])
    }
}