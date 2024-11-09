package com.example.impuestopredial

data class Predio (val area: Double, val zona: Zona){

    fun calcularImpuesto(): Double {
        return area * zona.costo
    }
}