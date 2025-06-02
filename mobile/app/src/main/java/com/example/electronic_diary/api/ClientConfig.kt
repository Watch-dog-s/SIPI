package com.example.electronic_diary.api

import com.example.electronic_diary.api.Remote.RegisterRequest
import com.example.electronic_diary.api.Remote.RegisterResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitClient {
    private const val BASE_URL = "http://localhost:8080"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

interface ApiService {
    @GET("/api/v1/auth/register")
    suspend fun register(registerRequest: RegisterRequest): RegisterResponse
}
