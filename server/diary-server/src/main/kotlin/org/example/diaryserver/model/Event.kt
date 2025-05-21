package org.example.diaryserver.model

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "event")
data class Event(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val groupId: String,

    @Column
    val startTime: OffsetDateTime,

    @Column
    val endTime: OffsetDateTime,

    @Column
    val name: String
)
