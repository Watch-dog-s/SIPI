package org.example.userservice.exception

import org.example.userservice.dto.response.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException

@RestControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(ResponseStatusException::class)
    fun handleResponseStatusException(ex: ResponseStatusException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(ex.statusCode)
            .body(
                ErrorResponse(
                status = ex.statusCode.value(),
                error = ex.reason ?: "Error",
                message = ex.message ?: ex.reason ?: ""
                )
            )
    }
}