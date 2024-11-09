package com.example.impuestopredial

import java.util.Locale

fun main() {
    // Crear objeto zonas
    val zonas = Zona.obtenerZonas()

    // Solicitar datos de la persona
    println("Ingrese el nombre de la persona:")
    val nombre = readlnOrNull() ?: ""

    println("Ingrese la edad de la persona:")
    val edad = readlnOrNull()?.toIntOrNull() ?: 0

    println("¿Es madre soltera? (S/N):")
    val esMadreSoltera = readlnOrNull()?.uppercase(Locale.ROOT) == "S"

    // Solicitar datos de los predios
    val predios = mutableListOf<Predio>()

    println("¿Cuántos predios tiene la persona?")
    val numPredios = readlnOrNull()?.toIntOrNull() ?: 0

    for (i in 1..numPredios) {
        println("Ingrese el área del predio $i en metros cuadrados:")
        val area = readlnOrNull()?.toDoubleOrNull() ?: 0.0

        println("Ingrese la clave de la zona del predio $i (MAR, RUR, URB, RES):")
        val claveZona = readlnOrNull() ?: ""

        val zona = zonas[claveZona.uppercase()] ?: Zona("DESCONOCIDA", "Desconocida", 0.0)
        predios.add(Predio(area, zona))
    }

    // Crear objeto persona
    val persona = Persona(nombre, edad, esMadreSoltera, predios)

    // Crear objeto calculadora de impuestos
    val calculadora = Calcular()

    // Solicitar el mes para calcular el importe
    println("Ingrese el mes (1-12) para calcular el importe a pagar:")
    val mes = readlnOrNull()?.toIntOrNull() ?: 1

    // Calcular el importe a pagar en el mes especificado
    val importe = calculadora.calcularImporteFinal(persona, mes)
    println("Importe a pagar en el mes $mes: $importe")
}
