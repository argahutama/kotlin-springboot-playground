package com.argahutama.playground.domain.usecase.user

import com.argahutama.playground.common.base.BaseUseCase
import com.argahutama.playground.domain.model.request.CreateUserRequest
import com.argahutama.playground.domain.model.response.UserResponse
import com.argahutama.playground.domain.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class CreateUserUseCase(
    private val repository: UserRepository
) : BaseUseCase<CreateUserRequest, UserResponse>() {
    override fun invoke(request: CreateUserRequest): UserResponse {
        return repository.createUser(request)
    }
}