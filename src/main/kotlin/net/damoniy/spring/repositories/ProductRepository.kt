package net.damoniy.spring.repositories

import java.io.Serializable
import net.damoniy.spring.domain.Product
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface ProductRepository: JpaRepository<Product, Serializable> {
}
