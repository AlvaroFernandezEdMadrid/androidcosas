package com.example.aplicaciontareas

data class Tarea(
    var nombre:String,
    val categoria:TareasCategorias,
    var isSelected:Boolean=false
)