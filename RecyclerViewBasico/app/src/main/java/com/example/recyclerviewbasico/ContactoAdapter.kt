package com.example.recyclerviewbasico

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactoAdapter(private val contactos: List<Contacto>) : RecyclerView.Adapter<ContactoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val view = LayoutInflater.from(parent.context) .inflate(R.layout.item_contacto, parent, false)
        return ContactoViewHolder(view);

    }

    override fun getItemCount(): Int {
        return contactos.size;
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val contacto=contactos[position];
        holder.tvNombre.text=contacto.nombre;
        holder.tvTelefono.text=contacto.telefono;

    }

}