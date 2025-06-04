package com.example.electronic_diary.api

import com.example.electronic_diary.api.dto.MarksRequest
import com.example.electronic_diary.api.dto.MarksResponse
import com.example.electronic_diary.api.dto.ScheduleRequest
import com.example.electronic_diary.api.dto.ScheduleResponse
import com.example.electronic_diary.api.dto.Subject
import com.example.electronic_diary.api.dto.SubjectRequest
import com.example.electronic_diary.api.dto.SubjectResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET

object ApiClientDiary {
    //private const val BASE_URL = "http://172.24.135.177:8080"
    private const val BASE_URL = "http://192.168.1.141:8080"

    val retrofit: ApiServiceDiary by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServiceDiary::class.java)
    }
}

interface ApiServiceDiary {
    @GET("/api/v1/schedule")
    suspend fun getSchedule(@Body request: ScheduleRequest): ScheduleResponse

    @GET("/api/v1/subject")
    suspend fun getSubject(@Body request: SubjectRequest): List<Subject>

    @GET("/api/v1/mark/subject/{id}")
    suspend fun getMarks(@Body request: MarksRequest): MarksResponse

}