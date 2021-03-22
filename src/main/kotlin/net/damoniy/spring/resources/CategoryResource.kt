package net.damoniy.spring.resources

import net.damoniy.spring.domain.Category
import net.damoniy.spring.services.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/category")
class CategoryResource(private val cs: CategoryService) {

    @RequestMapping(value=["/{id}"], method=[RequestMethod.GET])
    fun find(@PathVariable(value = "id") id: Int): ResponseEntity<Category> {
        return ResponseEntity.ok().body((cs.find(id)))
    }
}