package com.example.vuelos

// Main.kt
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val reservas = mutableListOf<Reserva>()

    var continuar = true

    while (continuar) {
        println("Seleccione el tipo de reserva a agregar:")
        println("1. Reserva Individual")
        println("2. Reserva Grupal")
        print("Ingrese una opción (1-2): ")
        val opcion = scanner.nextInt()

        when (opcion) {
            1 -> {
                // Captura datos para una ReservaIndividual
                print("Ingrese el nombre del pasajero: ")
                val pasajero = scanner.next()

                print("Ingrese el costo base: ")
                val costoBase = scanner.nextDouble()

                println("Seleccione la tarifa:")
                println("1. Económica")
                println("2. Ejecutiva")
                print("Ingrese la tarifa (1-2): ")
                val tarifaOpcion = scanner.nextInt()
                val tarifa = if (tarifaOpcion == 1) Tarifa.ECONOMICA else Tarifa.EJECUTIVA

                val reservaIndividual = ReservaIndividual(pasajero, costoBase, tarifa)
                reservas.add(reservaIndividual)
                println("Reserva individual agregada.\n")
            }
            2 -> {
                // Captura datos para una ReservaGrupal
                print("Ingrese el descuento grupal (en porcentaje, por ejemplo 10 para 10%): ")
                val descuento = scanner.nextDouble() / 100.0

                val reservaGrupal = ReservaGrupal(descuento)

                println("¿Desea agregar reservas individuales o agregar otra reserva grupal dentro de esta?")
                println("1. Agregar reservas individuales")
                println("2. Agregar otra reserva grupal")
                print("Ingrese una opción (1-2): ")
                val subOpcion = scanner.nextInt()

                when (subOpcion) {
                    1 -> {
                        println("¿Cuántas reservas individuales desea agregar a esta reserva grupal?")
                        val numReservas = scanner.nextInt()

                        for (i in 1..numReservas) {
                            print("Ingrese el nombre del pasajero $i: ")
                            val pasajero = scanner.next()

                            print("Ingrese el costo base para el pasajero $i: ")
                            val costoBase = scanner.nextDouble()

                            println("Seleccione la tarifa para el pasajero $i:")
                            println("1. Económica")
                            println("2. Ejecutiva")
                            print("Ingrese la tarifa (1-2): ")
                            val tarifaOpcion = scanner.nextInt()
                            val tarifa = if (tarifaOpcion == 1) Tarifa.ECONOMICA else Tarifa.EJECUTIVA

                            val reservaIndividual = ReservaIndividual(pasajero, costoBase, tarifa)
                            reservaGrupal.agregarReserva(reservaIndividual)
                        }
                    }
                    2 -> {
                        // Agregar una reserva grupal dentro de otra reserva grupal
                        print("Ingrese el descuento para la nueva reserva grupal (en porcentaje, por ejemplo 10 para 10%): ")
                        val nuevoDescuento = scanner.nextDouble() / 100.0
                        val nuevaReservaGrupal = ReservaGrupal(nuevoDescuento)
                        reservaGrupal.agregarReserva(nuevaReservaGrupal)
                        println("Reserva grupal anidada agregada.\n")
                    }
                    else -> {
                        println("Opción no válida.")
                    }
                }

                reservas.add(reservaGrupal)
                println("Reserva grupal agregada.\n")
            }
            else -> {
                println("Opción no válida. Intente de nuevo.")
            }
        }

        // Preguntar si el usuario quiere seguir agregando más reservas
        print("¿Desea agregar otra reserva? (sí/no): ")
        continuar = scanner.next().equals("sí", ignoreCase = true)
    }

    // Mostrar todas las reservas y calcular el costo total
    println("\nReservas agregadas:")
    for (reserva in reservas) {
        println(reserva)
    }

    val costoTotal = reservas.sumOf { it.calcularCosto() }
    println("Costo total de todas las reservas: $costoTotal")
}
