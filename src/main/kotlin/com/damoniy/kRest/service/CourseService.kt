package com.damoniy.kRest.service

import com.damoniy.kRest.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var courses: List<Course>) {

    init {
        val course = Course(id = 1, name = "Curso Kotlin Spring", category = "Kotlin")
        courses = Arrays.asList(course)
    }

    fun findById(id: Long): Course {
        return courses.stream().filter { c -> c.id == id }.findFirst().get()
    }
}