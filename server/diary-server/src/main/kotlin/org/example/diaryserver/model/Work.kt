package org.example.diaryserver.model


import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "work")
data class Work(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val dateTime: OffsetDateTime,

    @Column
    val description: String?,

    @Column
    val type: String,

    @Column
    val studentId: Long,

    @Column
    val subjectId: Long,
)