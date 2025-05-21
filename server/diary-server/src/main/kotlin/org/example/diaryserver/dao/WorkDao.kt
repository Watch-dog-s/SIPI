package org.example.diaryserver.dao

import org.example.diaryserver.dto.request.CreateWorkDTO
import org.example.diaryserver.model.Work
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class WorkDao(
    private val jdbc: NamedParameterJdbcTemplate
) {
    companion object {
        private const val SELECT_BY_ID = """
            SELECT 
                id,
                date_time,
                description,
                type,
                student_id,
                subject_id
             FROM work WHERE id = :id
            """
        private const val INSERT = """
            insert into work(date_time, description, type, student_id, subject_id) 
            values (:dateTime, :description, :type, :studentId, :subjectId)
            """
        private const val UPDATE = """
            update work 
            set description = :description,
                type = :type,
                subject_id = :subjectId,
                date_time = :dateTime
            where id = :id and student_id = :studentId
            """
        private const val DELETE = """
            delete from work 
            where id = :id
            """
        private val WORK_MAPPER = RowMapper { rs, _ ->
            Work(
                id = rs.getLong("id"),
                dateTime = rs.getObject("date_time", OffsetDateTime::class.java),
                description = rs.getString("description"),
                type = rs.getString("type"),
                studentId = rs.getLong("student_id"),
                subjectId = rs.getLong("subject_id")
            )
        }
    }

    fun getById(id: Long): Work? {
        return jdbc.query(
            SELECT_BY_ID,
            mapOf("id" to id),
            WORK_MAPPER
        ).firstOrNull()
    }

    fun createWork(userId: Long, work: CreateWorkDTO) {
        val params = MapSqlParameterSource()
            .addValue("dateTime", OffsetDateTime.now())
            .addValue("description", work.description)
            .addValue("type", work.type)
            .addValue("studentId", userId)
            .addValue("subjectId", work.subjectId)
        jdbc.update(INSERT, params)
    }

    fun updateWork(id: Long, userId: Long, work: CreateWorkDTO) {
        val params = MapSqlParameterSource()
            .addValue("id", id)
            .addValue("dateTime", OffsetDateTime.now())
            .addValue("description", work.description)
            .addValue("type", work.type)
            .addValue("studentId", userId)
            .addValue("subjectId", work.subjectId)
        jdbc.update(UPDATE, params)
    }

    fun deleteWork(id: Long) {
        val params = MapSqlParameterSource()
            .addValue("id", id)
        jdbc.update(DELETE, params)
    }
}