package com.example.aplicaciontareas

sealed class TareasCategorias {
    object Personal: TareasCategorias()
    object Negocios: TareasCategorias()
    object Otros: TareasCategorias()
}
