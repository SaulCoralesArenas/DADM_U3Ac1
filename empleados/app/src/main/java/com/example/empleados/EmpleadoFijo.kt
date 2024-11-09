package com.example.empleados

// Clase para empleados fijos
class EmpleadoFijo(
    nombre: String,
    id: Int,
    private val salarioFijo: Double
) : Empleado(nombre, id) {
    override fun calcularSalario(): Double {
        return salarioFijo
    }
}
