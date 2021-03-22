package net.damoniy.spring

import net.damoniy.spring.domain.Category
import net.damoniy.spring.domain.Product
import net.damoniy.spring.repositories.CategoryRepository
import net.damoniy.spring.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinspringApplication(@Autowired private val cr: CategoryRepository, @Autowired private val pr: ProductRepository): CommandLineRunner {

override fun run(vararg args: String?) {
	val c1 = Category(null, "Informática")
	val c2 = Category(null, "Escritório")

	val p1 = Product(null, "PC", 2000.00)
	val p2 = Product(null, "Impressora", 800.00)
	val p3 = Product(null, "Mouse", 80.00)

	(c1.products as ArrayList<Product>).addAll(listOf(p1, p2, p3))
	(c2.products as ArrayList<Product>).addAll(listOf(p2))

	(p1.categories as ArrayList<Category>).addAll(listOf(c1))
	(p2.categories as ArrayList<Category>).addAll(listOf(c1, c2))
	(p3.categories as ArrayList<Category>).addAll(listOf(c1))

	cr.saveAll(listOf(c1, c2))
	pr.saveAll(listOf(p1, p2, p3))
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinspringApplication>(*args)
}
