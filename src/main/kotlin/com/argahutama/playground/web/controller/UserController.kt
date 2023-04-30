package com.argahutama.playground.web.controller

import com.argahutama.playground.domain.model.request.CreatePostRequest
import com.argahutama.playground.domain.model.request.CreateUserRequest
import com.argahutama.playground.domain.model.response.PostResponse
import com.argahutama.playground.domain.model.response.UserResponse
import com.argahutama.playground.domain.usecase.post.CreatePostUseCase
import com.argahutama.playground.domain.usecase.post.GetPostsByUserIdUseCase
import com.argahutama.playground.domain.usecase.user.CreateUserUseCase
import com.argahutama.playground.domain.usecase.user.DeleteUserByIdUseCase
import com.argahutama.playground.domain.usecase.user.GetAllUsersUseCase
import com.argahutama.playground.domain.usecase.user.GetUserByIdUseCase
import com.argahutama.playground.common.exception.UserNotFoundException
import jakarta.validation.Valid
import org.springframework.context.MessageSource
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/users")
class UserController(
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val deleteUserByIdUseCase: DeleteUserByIdUseCase,
    private val getAllPostsByUserIdUseCase: GetPostsByUserIdUseCase,
    private val createPostUseCase: CreatePostUseCase,
    private val messageSource: MessageSource
) {
    @GetMapping("")
    fun retrieveAllUsers(): List<UserResponse> {
        return getAllUsersUseCase.invoke(null)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Int): EntityModel<UserResponse> {
        val user = getUserByIdUseCase.invoke(id) ?: throw UserNotFoundException(messageSource)

        return EntityModel.of(user).apply {
            add(linkTo<UserController> { retrieveAllUsers() }.withRel("all-users"))
        }
    }

    @PostMapping("")
    fun createUser(
        @Valid @RequestBody request: CreateUserRequest
    ): ResponseEntity<CreateUserRequest> {
        val savedUser = createUserUseCase.invoke(request)
        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: Int) {
        deleteUserByIdUseCase.invoke(id)
    }

    @GetMapping("/{id}/posts")
    fun retrieveAllPostsByUserId(@PathVariable id: Int): List<PostResponse> {
        val user = getUserByIdUseCase.invoke(id) ?: throw UserNotFoundException(messageSource)
        return getAllPostsByUserIdUseCase.invoke(user.id)
    }

    @PostMapping("/{id}/posts")
    fun createPost(
        @PathVariable("id") userId: Int,
        @Valid @RequestBody request: CreatePostRequest
    ): ResponseEntity<PostResponse> {
        request.user = CreateUserRequest(id = userId)
        val savedPost = createPostUseCase.invoke(request)
        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedPost.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }
}