package org.example.diaryserver.model

import jakarta.persistence.*

@Entity
@Table(name = "subject")
data class Subject(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
)
