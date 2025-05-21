package org.example.diaryserver.dto.request

data class CreateWorkDTO (
    val description: String?,
    val type: String,
    val subjectId: Long,
)