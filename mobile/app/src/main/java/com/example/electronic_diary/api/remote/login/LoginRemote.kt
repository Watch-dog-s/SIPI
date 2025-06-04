package com.example.electronic_diary.api.remote.login

import com.example.electronic_diary.api.ApiClientLogin
import com.example.electronic_diary.api.dto.LoginRequest

suspend fun loginUser(loginRequest: LoginRequest) : Result<String>
{
    try {
        val response = ApiClientLogin.retrofit.login(loginRequest)
        val token = response.token

        return Result.success(token)
    } catch (e: Exception) {
        return Result.failure(e)
    }
}