package com.example.electronic_diary.api.remote.diary

import com.example.electronic_diary.api.ApiClientDiary
import com.example.electronic_diary.api.dto.Subject
import com.example.electronic_diary.api.dto.SubjectRequest
import com.example.electronic_diary.api.dto.SubjectResponse

suspend fun getSubject(subjectRequest: SubjectRequest) : Result<List<Subject>>{
    try {
        val response = ApiClientDiary.retrofit.getSubject(subjectRequest)
        return Result.success(response)
    } catch (e : Exception) {
        return Result.failure(e)
    }
}