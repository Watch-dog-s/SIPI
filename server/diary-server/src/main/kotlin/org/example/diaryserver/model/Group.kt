package org.example.diaryserver.model

import jakarta.persistence.*

@Entity
@Table(name = "group")
data class Group(
    @Id
    val id: Long,

    @Column
    val name: String
)
