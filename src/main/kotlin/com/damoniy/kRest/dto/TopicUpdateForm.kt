package com.damoniy.kRest.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicUpdateForm(
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 7, max = 100) val title: String,
    @field:NotEmpty val message: String
)