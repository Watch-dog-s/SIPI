package org.example.diaryserver.dto.request

import java.time.OffsetDateTime

data class CreateEventDTO(
    val groupId: String,
    val startTime: OffsetDateTime,
    val endTime: OffsetDateTime,
    val name: String
)