package org.example.diaryserver.model

import jakarta.persistence.*

@Entity
@Table(name = "study_group")
data class Group(
    @Id
    val id: Long,

    @Column
    val name: String
)
