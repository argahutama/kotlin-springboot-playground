package com.argahutama.playground.domain.repository

import com.argahutama.playground.domain.model.request.CreateUserRequest
import com.argahutama.playground.domain.model.response.UserResponse

interface UserRepository {
    fun createUser(request: CreateUserRequest): UserResponse
    fun deleteUserById(id: Int)
    fun getAllUsers(): List<UserResponse>
    fun getUserById(id: Int): UserResponse
}