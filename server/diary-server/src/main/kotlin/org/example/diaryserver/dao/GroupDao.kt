package org.example.diaryserver.dao

import org.example.diaryserver.dto.request.AddUserToGroupDTO
import org.example.diaryserver.model.Group
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class GroupDao(
    private val jdbc: NamedParameterJdbcTemplate
) {
    companion object {
        private const val INSERT_USER_TO_GROUP = """
            insert into user_group(user_id, group_id) 
            values (:userId, :groupId)
            """

        private const val CHECK_USER_IN_GROUP = """
            select count(*)
            from user_group
            where user_id = :userId and group_id = :groupId
            """

        private const val CHECK_GROUP_EXISTS = """
            select count(*)
            from `group`
            where id = :groupId
            """

        private const val SELECT_USER_GROUPS = """
            select 
                g.id,
                g.name
            from `group` g
            join user_group ug on ug.group_id = g.id
            where ug.user_id = :userId
            """

        private val GROUP_MAPPER = RowMapper { rs, _ ->
            Group(
                id = rs.getLong("id"),
                name = rs.getString("name")
            )
        }
    }

    fun addUserToGroup(request: AddUserToGroupDTO) {
        val params = MapSqlParameterSource()
            .addValue("userId", request.userId)
            .addValue("groupId", request.groupId)
        jdbc.update(INSERT_USER_TO_GROUP, params)
    }

    fun isUserInGroup(userId: Long, groupId: Long): Boolean {
        val params = MapSqlParameterSource()
            .addValue("userId", userId)
            .addValue("groupId", groupId)
        return jdbc.queryForObject(CHECK_USER_IN_GROUP, params, Int::class.java)!! > 0
    }

    fun doesGroupExist(groupId: Long): Boolean {
        val params = MapSqlParameterSource()
            .addValue("groupId", groupId)
        return jdbc.queryForObject(CHECK_GROUP_EXISTS, params, Int::class.java)!! > 0
    }

    fun getUserGroups(userId: Long): List<Group> {
        val params = MapSqlParameterSource()
            .addValue("userId", userId)
        return jdbc.query(SELECT_USER_GROUPS, params, GROUP_MAPPER)
    }
} 