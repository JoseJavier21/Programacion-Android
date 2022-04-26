package com.example.myapplication.dataclass

data class Persona(var nombre: String, var apellidos: String, var edad: Int = 0, var alias: String = "") {

//    private var nombreCompleto= "$nombre $apellidos"
//        get() {
//            return field.uppercase()
//        }
//        set (value) {
//           field = "$value 1"
//        }
    constructor(nombre: String, edad: Int, person: Persona) : this(nombre, person.apellidos) {
        this.edad = edad
    }

//    fun imprimirNombre(): String {
//        return nombreCompleto
//    }

    inner class Dni(var numero: Int, var letra: Char)
}
