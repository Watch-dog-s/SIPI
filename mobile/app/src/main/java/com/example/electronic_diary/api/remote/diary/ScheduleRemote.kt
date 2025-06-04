package com.example.electronic_diary.api.remote.diary

import com.example.electronic_diary.api.ApiClientDiary
import com.example.electronic_diary.api.dto.ScheduleRequest
import com.example.electronic_diary.api.dto.ScheduleResponse


suspend fun getSchedule(scheduleRequest: ScheduleRequest) : Result<ScheduleResponse>{
    try {
        val response = ApiClientDiary.retrofit.getSchedule(scheduleRequest)
        return Result.success(response)
    } catch (e : Exception) {
        return Result.failure(e)
    }
}