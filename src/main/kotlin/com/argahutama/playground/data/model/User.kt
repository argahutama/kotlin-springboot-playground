package com.argahutama.playground.data.model

import com.argahutama.playground.domain.model.request.CreateUserRequest
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity(name = "user_details")
@JsonIgnoreProperties("posts")
data class User(
    @field:Id
    @field:GeneratedValue
    var id: Int? = null,
    @field:Size(min = 2, message = "{name.length.error}")
    val name: String? = null,
    @field:Past(message = "{birthdate.past.error}")
    val birthDate: LocalDate = LocalDate.now(),
    @field:OneToMany(mappedBy = "user")
    val posts: List<Post>? = null
) {
    constructor(request: CreateUserRequest) : this(
        name = request.name,
        birthDate = request.birthDate
    )
}