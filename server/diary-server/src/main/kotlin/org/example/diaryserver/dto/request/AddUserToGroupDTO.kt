package org.example.diaryserver.dto.request

data class AddUserToGroupDTO(
    val userId: Long,
    val groupId: Long
) 