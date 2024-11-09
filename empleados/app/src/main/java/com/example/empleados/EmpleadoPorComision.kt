package com.example.empleados

// Clase para empleados por comisión
class EmpleadoPorComision(
    nombre: String,
    id: Int,
    private val salarioBase: Double,
    private val porcentajeComision: Double,
    private val ventasGeneradas: Double
) : Empleado(nombre, id) {
    override fun calcularSalario(): Double {
        return salarioBase + (porcentajeComision * ventasGeneradas)
    }
}