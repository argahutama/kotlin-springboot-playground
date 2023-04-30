package com.argahutama.playground.domain.model.response

import java.time.LocalDate

data class UserResponse(
    var id: Int,
    val name: String,
    val birthDate: LocalDate
)