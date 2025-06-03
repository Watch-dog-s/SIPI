package com.example.electronic_diary.api.dto

data class RegisterRequest(
    val username : String,
    val email : String,
    val password : String
)

data class RegisterResponse(
    val token : String
)