package com.example.superherorecycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.superherorecycleractivity.R

class SuperHeroViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val superHero=view.findViewById<TextView>(R.id.tvSuperHeroName);
    val publicacion=view.findViewById<TextView>(R.id.tvSuperHeroPublisher);
    val realname=view.findViewById<TextView>(R.id.tvSuperHeroRealName);
    val foto=view.findViewById<ImageView>(R.id.ivSuperHero);

    fun render(superHeroModel:SuperHero){
        superHero.text=superHeroModel.superhero;
        publicacion.text=superHeroModel.publicacion;
        realname.text=superHeroModel.realName;
        Glide.with(foto.context).load(superHeroModel.foto).into(foto)

        //Al hacer solo en la foto
        foto.setOnClickListener{
            Toast.makeText(foto.context, superHeroModel.realName, Toast.LENGTH_SHORT).show()
        }
        //Al hacer click en toda la card
        itemView.setOnClickListener{
            Toast.makeText(foto.context, superHeroModel.realName, Toast.LENGTH_SHORT).show()
        }
    }
}
