package org.example.diaryserver.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.OffsetDateTime

@Entity
@Table(name = "student")
data class Student(
    @Id
    val userId: Long,

    @Column
    val fullName: String,

    @Column
    val date: OffsetDateTime
)
