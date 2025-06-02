package org.example.diaryserver.dto.request

data class CreateCommentDTO(
    val wordId : Long,
    val text: String
)