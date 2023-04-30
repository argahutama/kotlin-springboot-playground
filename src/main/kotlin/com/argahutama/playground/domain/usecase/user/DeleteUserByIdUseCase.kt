package com.argahutama.playground.domain.usecase.user

import com.argahutama.playground.common.base.BaseUseCase
import com.argahutama.playground.domain.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class DeleteUserByIdUseCase(
    private val repository: UserRepository
) : BaseUseCase<Int, Unit>() {
    override fun invoke(request: Int) {
        repository.deleteUserById(request)
    }
}