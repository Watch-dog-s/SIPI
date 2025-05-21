package org.example.diaryserver.service

import org.example.diaryserver.client.UserClient
import org.example.diaryserver.dao.GroupDao
import org.example.diaryserver.dto.request.AddUserToGroupDTO
import org.example.diaryserver.model.Group
import org.springframework.stereotype.Service

@Service
class GroupService(
    private val groupDao: GroupDao,
    private val userClient: UserClient
) {
    fun addUserToGroup(token: String, request: AddUserToGroupDTO) {
        if (!groupDao.doesGroupExist(request.groupId)) {
            throw IllegalArgumentException("Group not found")
        }

        if (groupDao.isUserInGroup(request.userId, request.groupId)) {
            throw IllegalArgumentException("User is already in this group")
        }

        groupDao.addUserToGroup(request)
    }

    fun getUserGroups(token: String): List<Group> {
        val userId = userClient.getUserIdByToken(token)
        return groupDao.getUserGroups(userId)
    }
} 