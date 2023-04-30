package com.argahutama.playground.common.exception

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class UserNotFoundException(
    private val messageSource: MessageSource
) : RuntimeException() {
    override val message get() = messageSource.getMessage(
        "user.not.found",
        null,
        "Default Message",
        LocaleContextHolder.getLocale()
    ).orEmpty()
}