package com.example.examenandroid

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val superHero = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val publicacion = view.findViewById<TextView>(R.id.tvSuperHeroPublisher)
    val realname = view.findViewById<TextView>(R.id.tvSuperHeroRealName)
    val foto = view.findViewById<ImageView>(R.id.ivSuperHero)

    fun render(superHeroModel: SuperHero) {
        superHero.text = superHeroModel.superhero
        publicacion.text = superHeroModel.publicacion
        realname.text = superHeroModel.realName
        Glide.with(foto.context).load(superHeroModel.foto).into(foto)

        itemView.setOnClickListener {
            val context = itemView.context
            val intent = Intent(context, FinalActivity::class.java).apply {
                putExtra("SUPERHERO_NAME", superHeroModel.superhero)
            }
            context.startActivity(intent)
        }
    }
}
