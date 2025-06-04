package com.example.electronic_diary.api.dto

import java.time.OffsetDateTime

data class ScheduleRequest(
    val token : String
)

data class ScheduleResponse(
    val id: Long,
    val groupId: String,
    val startTime: OffsetDateTime,
    val endTime: OffsetDateTime,
    val name: String,
    val subjectName: String,
    val place: String,
    val teacherName: String
)