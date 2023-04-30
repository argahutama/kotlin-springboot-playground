package com.argahutama.playground.data.repository.impl

import com.argahutama.playground.common.exception.UserNotFoundException
import com.argahutama.playground.data.dao.UserDao
import com.argahutama.playground.data.mapper.UserMapper
import com.argahutama.playground.data.model.User
import com.argahutama.playground.domain.model.request.CreateUserRequest
import com.argahutama.playground.domain.model.response.UserResponse
import com.argahutama.playground.domain.repository.UserRepository
import org.springframework.context.MessageSource
import org.springframework.stereotype.Component

@Component
class UserRepositoryImpl(
    private val userDao: UserDao,
    private val userMapper: UserMapper,
    private val messageSource: MessageSource
) : UserRepository {
    override fun createUser(request: CreateUserRequest): UserResponse {
        val user = userDao.save(User(request))
        return userMapper.map(user)
    }

    override fun deleteUserById(id: Int) {
        userDao.deleteById(id)
    }

    override fun getAllUsers(): List<UserResponse> {
        val users = userDao.findAll()
        return users.map { userMapper.map(it) }
    }

    override fun getUserById(id: Int): UserResponse {
        val user = userDao.findById(id).orElseThrow { UserNotFoundException(messageSource) }
        return userMapper.map(user)
    }
}