package org.example.diaryserver.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user_group")
data class UserGroup(
    @Id
    val userId: Long,

    @Id
    val groupId: Long,
)
