package net.damoniy.spring.resources

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value= ["/category"])
class CategoryResource {

    @RequestMapping(method=[RequestMethod.GET])
    fun doList(): String{
        return "Rest is already working!"
    }
}