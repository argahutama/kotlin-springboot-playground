package com.argahutama.playground.common.exception.handler

import com.argahutama.playground.domain.model.response.ErrorDetailsResponse
import com.argahutama.playground.common.exception.UserNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@RestControllerAdvice
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleGenericExceptions(
        ex: Exception,
        request: WebRequest
    ): ResponseEntity<Any> {
        val error = HttpStatus.INTERNAL_SERVER_ERROR
        val errorDetails = ErrorDetailsResponse(
            LocalDateTime.now(),
            ex.message.orEmpty(),
            error.value(),
            request.getDescription(false)
        )
        return ResponseEntity(errorDetails, error)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(
        ex: Exception,
        request: WebRequest
    ): ResponseEntity<Any> {
        val error = HttpStatus.NOT_FOUND
        val errorDetails = ErrorDetailsResponse(
            LocalDateTime.now(),
            ex.message.orEmpty(),
            error.value(),
            request.getDescription(false)
        )
        return ResponseEntity(errorDetails, error)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any> {
        val error = HttpStatus.BAD_REQUEST
        val errorDetails = ErrorDetailsResponse(
            LocalDateTime.now(),
            ex.fieldErrors.map { it.defaultMessage }.reversed().joinToString(),
            error.value(),
            request.getDescription(false)
        )
        return ResponseEntity(errorDetails, error)
    }
}