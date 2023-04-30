package com.argahutama.playground.domain.model.response

import java.time.LocalDateTime

data class ErrorDetailsResponse(
    val timestamp: LocalDateTime,
    val message: String,
    val code: Int,
    val details: String
)
