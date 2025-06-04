package com.example.electronic_diary.api.remote.login

import com.example.electronic_diary.api.ApiClientLogin
import com.example.electronic_diary.api.dto.RegisterRequest

suspend fun registerUser(registerRequest: RegisterRequest) : Result<String>
{
    try {
        val response = ApiClientLogin.retrofit.register(registerRequest)
        val token = response.token

        return Result.success(token)
    } catch (e: Exception) {
        return Result.failure(e)
    }
}