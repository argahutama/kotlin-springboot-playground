package com.argahutama.playground.domain.usecase.post

import com.argahutama.playground.common.base.BaseUseCase
import com.argahutama.playground.domain.model.response.PostResponse
import com.argahutama.playground.domain.repository.PostRepository
import org.springframework.stereotype.Component

@Component
class GetAllPostsUseCase(private val repository: PostRepository) : BaseUseCase<Any?, List<PostResponse>>() {
    override fun invoke(request: Any?): List<PostResponse> {
        return repository.getAllPosts()
    }
}