package com.example.electronic_diary.api.Remote

data class RegisterRequest(
    val login : String,
    val email : String,
    val password : String
)

data class RegisterResponse(
    val token : String
)