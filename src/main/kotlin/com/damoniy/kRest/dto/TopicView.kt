package com.damoniy.kRest.dto

import com.damoniy.kRest.model.TopicStatus
import java.time.LocalDateTime

data class TopicView(val id: Long?,
                     val title: String,
                     val message: String,
                     val status: TopicStatus,
                     val dateOf: LocalDateTime
                     )
