package com.argahutama.playground.domain.usecase.post

import com.argahutama.playground.common.base.BaseUseCase
import com.argahutama.playground.domain.model.request.CreatePostRequest
import com.argahutama.playground.domain.model.response.PostResponse
import com.argahutama.playground.domain.repository.PostRepository
import org.springframework.stereotype.Component

@Component
class CreatePostUseCase(private val repository: PostRepository) : BaseUseCase<CreatePostRequest, PostResponse>() {
    override fun invoke(request: CreatePostRequest): PostResponse {
        return repository.createPost(request)
    }
}