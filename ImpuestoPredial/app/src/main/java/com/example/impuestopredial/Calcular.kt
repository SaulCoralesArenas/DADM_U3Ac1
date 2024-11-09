package com.example.impuestopredial

class Calcular{
    fun calcularImporteFinal(persona: Persona, mes: Int): Double {
        val totalSinDescuento = persona.calcularTotalSinDescuento()
        val descuento = calcularDescuento(persona, mes)
        return totalSinDescuento * (1 - descuento)
    }

    private fun calcularDescuento(persona: Persona, mes: Int): Double {
        var totalDescontado = 0.0
        if ((persona.edad >= 70) || (persona.esMadreSoltera)) {
            totalDescontado = if (mes == 1 || mes == 2) {
                0.7
            } else 0.5
        } else {
            if (mes == 1 || mes == 2) {
                totalDescontado = 0.4
            }
        }
        return totalDescontado
    }
}