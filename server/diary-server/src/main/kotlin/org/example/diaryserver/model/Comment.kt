package org.example.diaryserver.model

import jakarta.persistence.*

@Entity
@Table(name = "comment")
data class Comment(
    @Id
    @Column(name = "work_id")
    val workId: Long,

    @Column
    val text: String
)
