package org.example.diaryserver.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "mark")
data class Mark(
    @Id
    @Column(name = "work_id")
    val workId: Long,

    @Column
    val value: Double,
)
