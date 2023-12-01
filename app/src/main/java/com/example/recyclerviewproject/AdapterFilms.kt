package com.example.recyclerviewproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterFilms(var filmList: List<RecyclerViewActivity.Film>, val eventListener: (RecyclerViewActivity.Film, View) -> Unit ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.my_cell, parent, false)

        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FilmViewHolder).bind(filmList[position], eventListener)
    }

    class FilmViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById(R.id.txtTitle) as TextView
        val description = itemView.findViewById(R.id.txtDescription) as TextView

        fun bind(film: RecyclerViewActivity.Film, eventListener: (RecyclerViewActivity.Film, View) -> Unit) {

            title.text = film.titulo
            description.text = film.descripcion
            itemView.setOnClickListener { eventListener(film, itemView)}

        }

    }

}

