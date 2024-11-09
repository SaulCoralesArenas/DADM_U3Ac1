package com.example.impuestopredial

data class Zona (val clave: String,val nombre: String, val costo: Double) {
    companion object {
        fun obtenerZonas(): Map<String, Zona> {
            return mapOf(
                "MAR" to Zona("MAR", "Marginado", 2.00),
                "RUR" to Zona("RUR", "Rural", 8.00),
                "URB" to Zona("URB", "Urbana", 10.00),
                "RES" to Zona("RES", "Residencial", 25.00)
            )
        }
    }
}


