package net.damoniy.spring

import net.damoniy.spring.domain.Category
import net.damoniy.spring.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class KotlinspringApplication(@Autowired private val cr: CategoryRepository): CommandLineRunner {

override fun run(vararg args: String?) {
	val c1 = Category(null, "Informática")
	val c2 = Category(null, "Escritório")

	cr.saveAll(listOf(c1, c2))
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinspringApplication>(*args)
}
