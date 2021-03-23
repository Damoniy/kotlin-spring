package net.damoniy.spring

import net.damoniy.spring.domain.Category
import net.damoniy.spring.domain.City
import net.damoniy.spring.domain.Product
import net.damoniy.spring.domain.State
import net.damoniy.spring.repositories.CategoryRepository
import net.damoniy.spring.repositories.CityRepository
import net.damoniy.spring.repositories.ProductRepository
import net.damoniy.spring.repositories.StateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinspringApplication(@Autowired private val cr: CategoryRepository, @Autowired private val pr: ProductRepository, @Autowired private val ct: CityRepository, @Autowired private val st: StateRepository): CommandLineRunner {

override fun run(vararg args: String?) {
	val c1 = Category(null, "Informática")
	val c2 = Category(null, "Escritório")

	val p1 = Product(null, "PC", 2000.00)
	val p2 = Product(null, "Impressora", 800.00)
	val p3 = Product(null, "Mouse", 80.00)

	val st1 = State(null, "Minas Gerais")
	val st2 = State(null, "São Paulo")

	val ct1 = City(null, "Uberlândia", st1)
	val ct2 = City(null, "São Paulo", st2)
	val ct3 = City(null, "Campinas", st2)

	(st1.cities as ArrayList<City>).addAll(listOf(ct1))
	(st2.cities as ArrayList<City>).addAll(listOf(ct2))
	(st2.cities as ArrayList<City>).addAll(listOf(ct3))

	(c1.products as ArrayList<Product>).addAll(listOf(p1, p2, p3))
	(c2.products as ArrayList<Product>).addAll(listOf(p2))

	(p1.categories as ArrayList<Category>).addAll(listOf(c1))
	(p2.categories as ArrayList<Category>).addAll(listOf(c1, c2))
	(p3.categories as ArrayList<Category>).addAll(listOf(c1))

	cr.saveAll(listOf(c1, c2))
	pr.saveAll(listOf(p1, p2, p3))
	st.saveAll(listOf(st1, st2))
	ct.saveAll(listOf(ct1, ct2, ct3))

	}
}

fun main(args: Array<String>) {
	runApplication<KotlinspringApplication>(*args)
}
