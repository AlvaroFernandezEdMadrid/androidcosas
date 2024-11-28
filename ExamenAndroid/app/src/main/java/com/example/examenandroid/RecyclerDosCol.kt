package com.example.examenandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerDosCol : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerdoscolumnas)

        val manager = GridLayoutManager(this, 2);
        val recyclerView = findViewById<RecyclerView>(R.id.vistaReciclada2);
        recyclerView.layoutManager = manager;
        recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList);
    }
}
