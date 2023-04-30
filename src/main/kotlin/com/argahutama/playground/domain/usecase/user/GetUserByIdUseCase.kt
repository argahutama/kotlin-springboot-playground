package com.argahutama.playground.domain.usecase.user

import com.argahutama.playground.common.base.BaseUseCase
import com.argahutama.playground.domain.model.response.UserResponse
import com.argahutama.playground.domain.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class GetUserByIdUseCase(
    private val repository: UserRepository
) : BaseUseCase<Int, UserResponse?>() {
    override fun invoke(request: Int): UserResponse? {
        return repository.getUserById(request)
    }
}