package org.example.diaryserver.dao

import org.example.diaryserver.model.Work
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class WorkDao(
    private val jdbc: NamedParameterJdbcTemplate
) {
    companion object {
        private const val SELECT_BY_ID = """
            SELECT * FROM work WHERE id = :id
            """
        private const val INSERT = """
            insert into works(id, dateTime, description, type) 
            values (:id, :dateTime, :description, :type)
            """
        private val WORK_MAPPER = RowMapper { rs, _ ->
            Work(
                id = rs.getLong("id"),
                dateTime = rs.getObject("dateTime", OffsetDateTime::class.java),
                description = rs.getString("description"),
                type = rs.getString("type"),
                studentId = rs.getLong("studentId"),
                subjectId = rs.getLong("subjectId")
            )
        }
    }

    fun getById(id: Long): Work? {
        val response = jdbc.query(
            SELECT_BY_ID,
            mapOf("id" to id),
            WORK_MAPPER
        ).first()
        return response
    }
}