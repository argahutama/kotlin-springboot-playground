package com.argahutama.playground.domain.usecase.post

import com.argahutama.playground.common.base.BaseUseCase
import com.argahutama.playground.domain.model.response.PostResponse
import com.argahutama.playground.domain.repository.PostRepository
import org.springframework.stereotype.Component

@Component
class GetPostsByUserIdUseCase(private val repository: PostRepository) : BaseUseCase<Int, List<PostResponse>>() {
    override fun invoke(request: Int): List<PostResponse> {
        return repository.getPostsByUserId(request)
    }
}