package com.example.aplicaciontareas

sealed class TareasCategorias (var isSelected:Boolean=true){
    object Personal: TareasCategorias()
    object Negocios: TareasCategorias()
    object Otros: TareasCategorias()
}
