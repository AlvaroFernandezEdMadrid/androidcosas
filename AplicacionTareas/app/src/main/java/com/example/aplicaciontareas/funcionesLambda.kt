package com.example.aplicaciontareas

fun main(){
    val suma:(Int, Int) -> Int = {a,b->a+b}

    val resultado=suma(25,44)

    println(resultado)


    val saludar:(String) -> String={nombre->"Hola, $nombre"}

    val usuario=saludar("Paco")

    println(usuario)

    val mult = {x:Int, y:Int -> x*y}

    val res=mult(2,3)

    println(res)

    val decirHola : () -> String = { "Holaa" }

    println(decirHola)

    fun hacerAlgo(x:Int, y:Int, operar:(Int,Int)->Int){
        operar(x,y)
    }

    println(hacerAlgo(3,7,suma))

}