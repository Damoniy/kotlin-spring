package com.damoniy.kRest.mapper

import com.damoniy.kRest.dto.TopicForm
import com.damoniy.kRest.model.Topic
import com.damoniy.kRest.service.CourseService
import com.damoniy.kRest.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : RawMapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.idCourse),
            author = userService.findById(t.idAuthor)
        )
    }
}