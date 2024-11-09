package com.example.vuelos

// ReservaGrupal.kt
class ReservaGrupal(private val descuento: Double = 0.0) : Reserva {
    private val reservas = mutableListOf<Reserva>()

    // Método para agregar cualquier tipo de reserva (individual o grupal)
    fun agregarReserva(reserva: Reserva) {
        reservas.add(reserva)
    }

    override fun calcularCosto(): Double {
        val costoTotal = reservas.sumOf { it.calcularCosto() }
        return costoTotal - (costoTotal * descuento) // Aplicar descuento si existe
    }

    override fun toString(): String {
        val detalleReservas = reservas.joinToString(separator = "\n") { reserva ->
            "\t${reserva.toString()}" // Aumentamos el nivel de indentación para mejorar la legibilidad
        }
        return """
            |Reserva grupal con ${reservas.size} reservas:
            |$detalleReservas
            |Costo total: ${calcularCosto()}
            |Descuento aplicado: ${descuento * 100}% 
        """.trimMargin()
    }
}
