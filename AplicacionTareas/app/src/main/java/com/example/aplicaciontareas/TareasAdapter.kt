package com.example.aplicaciontareas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TareasAdapter(private val tareas: List<Tarea>, private val onTareaSelected:(Int)->Unit) : RecyclerView.Adapter<TareasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareasViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_tarea, parent, false)

        return TareasViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tareas.size
    }

    override fun onBindViewHolder(holder: TareasViewHolder, position: Int) {
        holder.render(tareas[position])
        holder.itemView.setOnClickListener{
            onTareaSelected(position)
        }
    }

}