package com.example.vuelos

// ReservaIndividual.kt
enum class Tarifa {
    ECONOMICA, EJECUTIVA
}

class ReservaIndividual(
    private val pasajero: String,
    private val costoBase: Double,
    private val tarifa: Tarifa
) : Reserva {
    override fun calcularCosto(): Double {
        return when (tarifa) {
            Tarifa.ECONOMICA -> costoBase
            Tarifa.EJECUTIVA -> costoBase * 1.5 // 50% más por ejecutiva
        }
    }

    override fun toString(): String {
        return "Reserva individual para $pasajero, Costo: ${calcularCosto()}, Tarifa: $tarifa"
    }
}
