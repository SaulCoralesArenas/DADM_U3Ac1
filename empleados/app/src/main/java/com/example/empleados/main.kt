package com.example.empleados

fun main() {
    // Lista de empleados de diferentes tipos
    val empleados = mutableListOf<Empleado>(
        EmpleadoFijo("Juan Pérez", 1, 2000.0),
        EmpleadoFijo("Carla Fernández", 2, 2200.0),
        EmpleadoPorHoras("Ana López", 3, 15.0, 45),  // 45 horas trabajadas
        EmpleadoPorHoras("Pedro Sánchez", 4, 20.0, 38),  // 38 horas trabajadas
        EmpleadoPorComision("Luis Gómez", 5, 800.0, 0.1, 5000.0), // 10% de comisión sobre 5000 en ventas
        EmpleadoPorComision("Laura Martínez", 6, 900.0, 0.12, 6000.0) // 12% de comisión sobre 6000 en ventas
    )

    // Calcular y mostrar la nómina de cada empleado
    for (empleado in empleados) {
        println("Empleado: ${empleado.nombre}, ID: ${empleado.id}, Salario: ${empleado.calcularSalario()}")
    }
}
