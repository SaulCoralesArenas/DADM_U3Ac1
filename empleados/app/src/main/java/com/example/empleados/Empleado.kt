package com.example.empleados

abstract class Empleado(
    val nombre: String,
    val id: Int
) {
    abstract fun calcularSalario(): Double
}
