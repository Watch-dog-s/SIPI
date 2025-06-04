package org.example.diaryserver.dto.response

import java.time.OffsetDateTime

data class EventResponse(
    val id: Long,
    val groupId: String,
    val startTime: OffsetDateTime,
    val endTime: OffsetDateTime,
    val name: String,
    val subjectName: String,
    val place: String,
    val teacherName: String,
)