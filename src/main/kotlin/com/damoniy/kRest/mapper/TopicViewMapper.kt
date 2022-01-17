package com.damoniy.kRest.mapper

import com.damoniy.kRest.dto.TopicView
import com.damoniy.kRest.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: RawMapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.state,
            dateOf = t.dateOf
        )
    }
}