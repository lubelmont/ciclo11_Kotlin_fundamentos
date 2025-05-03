package com.lubelsoft.miaplicacion101.ejercicios

fun main() {

    var nombreDeVariable = "mi Variable"
    var edad: Int = 35
    var altura: Double = 1.75
    var esEstudiante: Boolean = true

    println("Mi nombre es $nombreDeVariable")

    /**
     * For rango de numero
     *
     */
    for (i in 0..10) {           // Loop over a range from 0 to 10
        print(" $i")
    }

    val myArray = arrayOf("manzana", "pera", "Platano", "fresa", "mango")

    for (item in myArray) {
        println(item)
    }

    if (edad >= 18) {
        println("Soy mayor de edad.")
    } else {
        println("Soy menor de edad.")
    }

    imprimeResultado(9.0)
    imprimeResultado(7.5)

    var nombre: String? = null
    var nombre2: String? = "Juan"

    println(nombre?.length)
    println(nombre2?.length)



}

fun imprimeResultado(prom: Double){

    when {
        prom >= 9.0 -> println("Excelente")
        prom >= 7.0 -> println("Muy Bien")
        prom >= 5.0 -> println("Bien")
        else -> println("Reprobado")

    }


}