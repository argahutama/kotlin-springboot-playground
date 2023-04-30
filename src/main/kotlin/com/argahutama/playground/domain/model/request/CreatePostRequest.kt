package com.argahutama.playground.domain.model.request

import com.fasterxml.jackson.annotation.JsonIgnore

data class CreatePostRequest(
    val description: String?,
    @JsonIgnore()
    var user: CreateUserRequest?
)