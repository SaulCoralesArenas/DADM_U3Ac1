package com.example.impuestopredial

data class Persona(
    val nombre: String,
    val edad: Int,
    val esMadreSoltera: Boolean,
    val predios: List<Predio>)
{
    fun calcularTotalSinDescuento(): Double {
        var total = 0.0
        for (predio in predios) {
            total += predio.calcularImpuesto()
        }
        return total
    }
}
