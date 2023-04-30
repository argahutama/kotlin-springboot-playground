package com.argahutama.playground.domain.repository

import com.argahutama.playground.domain.model.request.CreatePostRequest
import com.argahutama.playground.domain.model.response.PostResponse

interface PostRepository {
    fun createPost(request: CreatePostRequest): PostResponse
    fun deletePostById(id: Int)
    fun getAllPosts(): List<PostResponse>
    fun getPostsByUserId(userId: Int): List<PostResponse>
    fun getPostById(id: Int): PostResponse
}