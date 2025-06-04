package com.example.electronic_diary.api.dto

data class LoginRequest(
    val username : String,
    val password : String
)

data class LoginResponse(
    val token : String
)