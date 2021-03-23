package net.damoniy.spring.domain

import java.io.Serializable
import javax.persistence.*

@Entity
class State(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int?, val name: String): Serializable {

    @OneToMany(mappedBy = "state")
    val cities: List<City> = ArrayList<City>()

    override fun hashCode(): Int {
        val prime = 30
        var result = 1
        result = prime * result + id.hashCode()

        return result
    }

    override fun equals(other: Any?): Boolean {
        other as Category

        return when(other){
            this === other -> true
            id != null && other.id == null -> false
            id == null && other.id != null -> false
            this::class.java == other::class.java -> true
            id != other.id -> false
            else -> true
        }
    }
}