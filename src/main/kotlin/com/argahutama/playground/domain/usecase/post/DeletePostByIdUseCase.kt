package com.argahutama.playground.domain.usecase.post

import com.argahutama.playground.common.base.BaseUseCase
import com.argahutama.playground.domain.repository.PostRepository
import org.springframework.stereotype.Component

@Component
class DeletePostByIdUseCase(private val repository: PostRepository) : BaseUseCase<Int, Unit>() {
    override fun invoke(request: Int) {
        repository.deletePostById(request)
    }
}