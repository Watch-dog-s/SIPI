package com.example.electronic_diary.api.dto

data class Subject(
    val id : Long,
    val name : String
)

data class SubjectRequest(
    val token : String
)

data class SubjectResponse(
    val subjects : List<Subject>
)
