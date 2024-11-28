package com.example.examenandroid

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finalactivity)

        val superHeroName = intent.getStringExtra("SUPERHERO_NAME") ?: return

        val superHero = SuperHeroProvider.superHeroList.find { it.superhero == superHeroName }

        val ivSuperHero = findViewById<ImageView>(R.id.ivSuperHeroFoto)
        val tvSuperHeroName = findViewById<TextView>(R.id.tvSuperHeroName)
        val tvSuperHeroRealName = findViewById<TextView>(R.id.tvSuperHeroRealName)
        val tvSuperHeroPublisher = findViewById<TextView>(R.id.tvSuperHeroPublisher)

        if (superHero != null) {
            tvSuperHeroName.text = superHero.superhero
        }
        if (superHero != null) {
            tvSuperHeroRealName.text = superHero.realName
        }
        if (superHero != null) {
            tvSuperHeroPublisher.text = superHero.publicacion
        }
        if (superHero != null) {
            Glide.with(this).load(superHero.foto).into(ivSuperHero)
        }
    }
}
