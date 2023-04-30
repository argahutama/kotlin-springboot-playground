package com.argahutama.playground.domain.model.request

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class CreateUserRequest(
    @field:Size(min = 2, message = "{name.length.error}")
    val name: String? = null,
    @field:Past(message = "{birthdate.past.error}")
    val birthDate: LocalDate = LocalDate.now(),
    @JsonIgnore()
    var id: Int? = null
)