package com.argahutama.playground.web.controller

import com.argahutama.playground.domain.model.response.PostResponse
import com.argahutama.playground.domain.usecase.post.DeletePostByIdUseCase
import com.argahutama.playground.domain.usecase.post.GetAllPostsUseCase
import com.argahutama.playground.domain.usecase.post.GetPostByIdUseCase
import com.argahutama.playground.common.exception.UserNotFoundException
import org.springframework.context.MessageSource
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val getPostByIdUseCase: GetPostByIdUseCase,
    private val deletePostByIdUseCase: DeletePostByIdUseCase,
    private val messageSource: MessageSource
) {
    @GetMapping("")
    fun retrieveAllPosts(): List<PostResponse> {
        return getAllPostsUseCase.invoke(null)
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Int): EntityModel<PostResponse> {
        val post = getPostByIdUseCase.invoke(id) ?: throw UserNotFoundException(messageSource)
        return EntityModel.of(post).apply {
            add(linkTo<PostController> { retrieveAllPosts() }.withRel("all-posts"))
        }
    }

    @DeleteMapping("/{id}")
    fun deletePostById(@PathVariable id: Int) {
        deletePostByIdUseCase.invoke(id)
    }
}