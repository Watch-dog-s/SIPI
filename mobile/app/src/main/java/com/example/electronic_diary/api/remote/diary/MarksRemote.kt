package com.example.electronic_diary.api.remote.diary

import com.example.electronic_diary.api.ApiClientDiary
import com.example.electronic_diary.api.dto.MarksRequest
import com.example.electronic_diary.api.dto.MarksResponse


suspend fun getMarks(marksRequest: MarksRequest) : Result<MarksResponse>{
    try {
        val response = ApiClientDiary.retrofit.getMarks(marksRequest)
        return Result.success(response)
    } catch (e : Exception) {
        return Result.failure(e)
    }
}