package com.argahutama.playground.domain.model.response

data class PostResponse(
    var id: Int = -1,
    val description: String,
    var userId: Int = -1
)