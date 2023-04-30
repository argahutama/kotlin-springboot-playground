package com.argahutama.playground.data.repository.impl

import com.argahutama.playground.common.exception.UserNotFoundException
import com.argahutama.playground.data.dao.PostDao
import com.argahutama.playground.data.dao.UserDao
import com.argahutama.playground.data.mapper.PostMapper
import com.argahutama.playground.data.model.Post
import com.argahutama.playground.domain.model.request.CreatePostRequest
import com.argahutama.playground.domain.model.response.PostResponse
import com.argahutama.playground.domain.repository.PostRepository
import org.springframework.context.MessageSource
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Component

@Component
class PostRepositoryImpl(
    private val postDao: PostDao,
    private val userDao: UserDao,
    private val postMapper: PostMapper,
    private val messageSource: MessageSource
) : PostRepository {

    override fun createPost(request: CreatePostRequest): PostResponse {
        userDao.findById(request.user?.id ?: -1).orElseThrow { UserNotFoundException(messageSource) }
        val post = postDao.save(Post(request))
        return postMapper.map(post)
    }

    override fun deletePostById(id: Int) {
        postDao.deleteById(id)
    }

    override fun getAllPosts(): List<PostResponse> {
        val posts = postDao.findAll()
        return posts.map { postMapper.map(it) }
    }

    override fun getPostsByUserId(userId: Int): List<PostResponse> {
        val posts = userDao.findById(userId).orElseThrow {
            UserNotFoundException(messageSource)
        }.posts.orEmpty()
        return posts.map { postMapper.map(it) }
    }

    override fun getPostById(id: Int): PostResponse {
        val post = postDao.findById(id).orElseThrow { NotFoundException() }
        return postMapper.map(post)
    }

}