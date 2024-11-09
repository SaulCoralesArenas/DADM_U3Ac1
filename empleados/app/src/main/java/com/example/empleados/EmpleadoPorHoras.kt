package com.example.empleados

// Clase para empleados por horas
class EmpleadoPorHoras(
    nombre: String,
    id: Int,
    private val tarifaPorHora: Double,
    private val horasTrabajadas: Int
) : Empleado(nombre, id) {
    override fun calcularSalario(): Double {
        val horasExtras = if (horasTrabajadas > 40) horasTrabajadas - 40 else 0
        val horasNormales = horasTrabajadas - horasExtras
        val salarioNormal = horasNormales * tarifaPorHora
        val salarioHorasExtras = horasExtras * tarifaPorHora * 1.5
        return salarioNormal + salarioHorasExtras
    }
}
