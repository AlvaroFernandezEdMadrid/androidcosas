package com.example.examenandroid

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val card1 = findViewById<CardView>(R.id.card1);

        card1.setOnClickListener {
            val intent1 = Intent(this, RecyclerUnaCol::class.java)
            startActivity(intent1)
        }

        val card2 = findViewById<CardView>(R.id.card2);

        card2.setOnClickListener {
            val intent2 = Intent(this, RecyclerDosCol::class.java)
            startActivity(intent2)
        }
    }
}