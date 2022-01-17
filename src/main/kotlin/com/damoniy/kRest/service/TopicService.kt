package com.damoniy.kRest.service

import com.damoniy.kRest.dto.TopicForm
import com.damoniy.kRest.dto.TopicUpdateForm
import com.damoniy.kRest.model.Course
import com.damoniy.kRest.model.Topic
import com.damoniy.kRest.model.User
import com.damoniy.kRest.dto.TopicView
import com.damoniy.kRest.exception.NotFoundException
import com.damoniy.kRest.mapper.TopicFormMapper
import com.damoniy.kRest.mapper.TopicViewMapper
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic>,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "O tópico do escopo não é válido.") {

    init {
        val topic0 = Topic(
            id = 0, title = "Duvidas Kotlin",
            message = "Variáveis do Kotlin",
            course = Course(0, "Kotlin", "Programação"),
            author = User(id = 0, name = "Acenélio", email = "acenelio@gmail.com")
        )

        val topic1 = Topic(
            id = 1, title = "Duvidas Kotlin",
            message = "Variáveis do Kotlin",
            course = Course(0, "Kotlin", "Programação"),
            author = User(id = 0, name = "Acenélio", email = "acenelio@gmail.com")
        )

        val topic2 = Topic(
            id = 2, title = "Duvidas Kotlin",
            message = "Variáveis do Kotlin",
            course = Course(0, "Kotlin", "Programação"),
            author = User(id = 0, name = "Acenélio", email = "acenelio@gmail.com")
        )

        topics = Arrays.asList(topic0, topic1, topic2)
    }


    fun list(): List<TopicView> {
        return topics.stream().map { topic -> topicViewMapper.map(topic)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic = findTopic(id)
        return TopicView(topic.id, topic.title, topic.message, topic.state, topic.dateOf)
    }

    private fun findTopic(id: Long): Topic {
        return topics.stream().filter { it.id == id }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
    }

    fun post(form: TopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong()
        topics = topics.plus(topic)

        return topicViewMapper.map(topic)
    }

    fun update(form: TopicUpdateForm): TopicView {
        val topic = this.findTopic(id = form.id)
        val updatedTopic = Topic(id = form.id,
            title = form.title,
            message = form.message,
            author = topic.author,
            course = topic.course,
            state = topic.state,
            dateOf = topic.dateOf)
        topics = topics.minus(topic).plus(updatedTopic)
        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topic = this.findTopic(id)
        topics = topics.minus(topic)
    }
}