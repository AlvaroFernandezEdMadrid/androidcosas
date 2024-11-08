package com.example.aplicaciontareas

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriasViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val tvCategoriaNombre:TextView=view.findViewById(R.id.tvCategoriaNombre)
    private val divisor:View=view.findViewById(R.id.divisor)

    fun render(TareasCategorias:TareasCategorias){
        tvCategoriaNombre.text="Negocios"

    }

}