package com.argahutama.playground.data.mapper

import com.argahutama.playground.common.base.BaseMapper
import com.argahutama.playground.data.model.User
import com.argahutama.playground.domain.model.response.UserResponse
import org.springframework.stereotype.Component

@Component
class UserMapper : BaseMapper<User, UserResponse>() {
    override fun map(from: User): UserResponse {
        return UserResponse(
            from.id ?: -1,
            from.name.orEmpty(),
            from.birthDate
        )
    }
}