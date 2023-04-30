package com.argahutama.playground.data.dao

import com.argahutama.playground.data.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(exported = false)
interface PostDao : JpaRepository<Post, Int>