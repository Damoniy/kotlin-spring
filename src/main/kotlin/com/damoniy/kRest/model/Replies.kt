package com.damoniy.kRest.model

import java.time.LocalDateTime

data class Replies(val id:Long? = null,
                   val message: String,
                   val dateOf: LocalDateTime = LocalDateTime.now(),
                   val author: User,
                   val topic: Topic,
                   val isSolution: Boolean)
