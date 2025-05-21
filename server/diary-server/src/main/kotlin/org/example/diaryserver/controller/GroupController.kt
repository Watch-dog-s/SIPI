package org.example.diaryserver.controller

import org.example.diaryserver.dto.request.AddUserToGroupDTO
import org.example.diaryserver.model.Group
import org.example.diaryserver.service.GroupService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/group")
class GroupController(
    private val groupService: GroupService
) {
    companion object {
        private const val TOKEN: String = "Authorization"
    }

    @PostMapping("/user")
    fun addUserToGroup(
        @RequestHeader(TOKEN) token: String,
        @RequestBody request: AddUserToGroupDTO
    ) {
        groupService.addUserToGroup(token, request)
    }

    @GetMapping("/my")
    fun getMyGroups(
        @RequestHeader(TOKEN) token: String
    ): List<Group> {
        return groupService.getUserGroups(token)
    }
} 