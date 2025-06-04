package com.example.electronic_diary.api.dto

data class Mark(
    val value : Double
)

data class MarksRequest(
    val token : String,
    val id : Long
)

data class MarksResponse(
    val marks : List<Mark>
)