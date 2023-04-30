package com.argahutama.playground.domain.usecase.post

import com.argahutama.playground.common.base.BaseUseCase
import com.argahutama.playground.domain.model.response.PostResponse
import com.argahutama.playground.domain.repository.PostRepository
import org.springframework.stereotype.Component

@Component
class GetPostByIdUseCase(private val repository: PostRepository) : BaseUseCase<Int, PostResponse?>() {
    override fun invoke(request: Int): PostResponse? {
        return repository.getPostById(request)
    }
}