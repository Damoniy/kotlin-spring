package net.damoniy.spring.resources

import net.damoniy.spring.domain.Category
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value=["/category"])
class CategoryResource {

    @RequestMapping(method=[RequestMethod.GET])
    fun doList(): List<Category>{
        val c0 = Category(1, "Informatica")
        val c1 = Category(2, "Escritório")

        val list = ArrayList<Category>()
        list.add(c0)
        list.add(c1)

        return list
    }
}