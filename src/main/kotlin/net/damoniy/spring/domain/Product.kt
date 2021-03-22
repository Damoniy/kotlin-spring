package net.damoniy.spring.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import java.io.Serializable
import javax.persistence.*
import java.util.ArrayList

@Entity
class Product(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int?, val name: String?, val price: Double?): Serializable {

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "PRODUCT_CATEGORY", joinColumns = [JoinColumn(name = "product_id")], inverseJoinColumns = [JoinColumn(name = "category_id")])
    val categories: List<Category> = ArrayList<Category>()

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