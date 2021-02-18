package com.example.ejemploPropio

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
//esto es la clase en la que almacenalos los datos es como una "tabla" de una bbdd
@Entity
class CryptoCurrency(var id:String,
                     var name: String,
                     var symbol:String,
                     var type:String) {
    //aqui le decimos que idAuto va a ser un id unico y que nos lo genere automaticamente spring
    @Id
    @GeneratedValue
    private val idAuto: Long? = null

    override fun equals(other: Any?): Boolean {
        if (other is CryptoCurrency){
            return other.idAuto == idAuto && idAuto != null
        } else {
            return false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(idAuto,id,name)
    }

    override fun toString(): String {
        return "$id es la moneda : $name con un id de $id"


    }
}