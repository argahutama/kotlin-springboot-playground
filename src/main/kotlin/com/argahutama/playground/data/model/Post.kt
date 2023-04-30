package com.argahutama.playground.data.model

import com.argahutama.playground.domain.model.request.CreatePostRequest
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity(name = "posts")
@JsonIgnoreProperties("user")
data class Post(
    @field:Id
    @field:GeneratedValue
    var id: Int? = null,
    val description: String,
    @field:ManyToOne(fetch = FetchType.LAZY)
    var user: User? = null
) {
    constructor(request: CreatePostRequest) : this(
        description = request.description.orEmpty(),
        user = User(id = request.user?.id ?: -1)
    )
}