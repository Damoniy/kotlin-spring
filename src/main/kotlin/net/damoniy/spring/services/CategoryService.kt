package net.damoniy.spring.services

import net.damoniy.spring.domain.Category
import net.damoniy.spring.repositories.CategoryRepository
import net.damoniy.spring.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(private val r: CategoryRepository) {

    fun find(id: Int): Category? {
        val obj: Optional<Category> = r.findById(id)
        return obj.orElseThrow {
            ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Category::class.java.name
            )
        }
    }
}