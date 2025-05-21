package org.example.diaryserver.dto.request

data class CreateMarkDTO(
    val workId: Long,
    val value: Double,
)