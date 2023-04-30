package com.argahutama.playground.domain.usecase.user

import com.argahutama.playground.common.base.BaseUseCase
import com.argahutama.playground.domain.model.response.UserResponse
import com.argahutama.playground.domain.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class GetAllUsersUseCase(
    private val repository: UserRepository
) : BaseUseCase<Any?, List<UserResponse>>() {
    override fun invoke(request: Any?): List<UserResponse> {
        return repository.getAllUsers()
    }
}