package com.argahutama.playground.data.mapper

import com.argahutama.playground.common.base.BaseMapper
import com.argahutama.playground.data.model.Post
import com.argahutama.playground.domain.model.response.PostResponse
import org.springframework.stereotype.Component

@Component
class PostMapper : BaseMapper<Post, PostResponse>() {
    override fun map(from: Post): PostResponse {
        return PostResponse(
            from.id ?: -1,
            from.description,
            from.user?.id ?: -1
        )
    }
}