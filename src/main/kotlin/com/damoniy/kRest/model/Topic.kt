package com.damoniy.kRest.model

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val dateOf: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val state: TopicStatus = TopicStatus.NOT_ANSWERED,
    val answers:List<Replies> = ArrayList())