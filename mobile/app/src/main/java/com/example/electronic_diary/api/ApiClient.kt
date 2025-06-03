package com.example.electronic_diary.api

import com.example.electronic_diary.api.dto.LoginRequest
import com.example.electronic_diary.api.dto.LoginResponse
import com.example.electronic_diary.api.dto.RegisterRequest
import com.example.electronic_diary.api.dto.RegisterResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

object ApiClient {
    private const val BASE_URL = "http://172.24.135.177:8081"

    val retrofit: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

interface ApiService {
    @POST("/api/v1/auth/register")
    suspend fun register(@Body request: RegisterRequest): RegisterResponse
    @POST("/api/v1/auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}
