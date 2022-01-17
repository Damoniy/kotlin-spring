package com.damoniy.kRest.controller

import com.damoniy.kRest.dto.TopicForm
import com.damoniy.kRest.dto.TopicUpdateForm
import com.damoniy.kRest.service.TopicService
import com.damoniy.kRest.dto.TopicView
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return service.findById(id)
    }

    @PostMapping
    fun post(@RequestBody @Valid form: TopicForm, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = service.post(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun update(@RequestBody @Valid updateForm: TopicUpdateForm): ResponseEntity<TopicView> {
        val updatedTopic = service.update(updateForm)

        return ResponseEntity.ok().body(updatedTopic)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}