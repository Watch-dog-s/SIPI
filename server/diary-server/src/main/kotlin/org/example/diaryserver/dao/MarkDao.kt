package org.example.diaryserver.dao

import org.example.diaryserver.dto.request.CreateMarkDTO
import org.example.diaryserver.model.Mark
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class MarkDao(
    private val jdbc: NamedParameterJdbcTemplate
) {
    companion object {
        private const val INSERT = """
            insert into mark(value, work_id) 
            values (:value,:workId)
            """

        private const val SELECT_MARK_BY_WORK_ID = """
            select 
                work_id,
                `value`
            from mark
            where work_id = :workId
        """

        private const val UPDATE = """
            update mark
            set value = :value
            where work_id = :workId
        """

        private const val DELETE = """
            delete from mark
            where work_id = :workId
        """

        private const val SELECT_MARKS_BY_SUBJECT = """
            select 
                m.work_id,
                m.value
            from mark m
            join work w on w.id = m.work_id
            where w.subject_id = :subjectId
        """

        private const val SELECT_AVERAGE_BY_SUBJECT = """
            select 
                w.subject_id as work_id,
                avg(m.value) as value
            from mark m
            join work w on w.id = m.work_id
            where w.subject_id = :subjectId
            group by w.subject_id
        """

        private val MARK_MAPPER = RowMapper { rs, _ ->
            Mark(
                workId = rs.getLong("work_id"),
                value = rs.getDouble("value")
            )
        }
    }

    fun insert(mark: CreateMarkDTO) {
        val params = MapSqlParameterSource()
            .addValue("workId", mark.workId)
            .addValue("value", mark.value)
        jdbc.update(INSERT, params)
    }

    fun selectByWorkId(workId: Long): Mark? {
        return jdbc.query(
            SELECT_MARK_BY_WORK_ID,
            mapOf("workId" to workId),
            MARK_MAPPER
        ).firstOrNull()
    }

    fun update(mark: CreateMarkDTO) {
        val params = MapSqlParameterSource()
            .addValue("workId", mark.workId)
            .addValue("value", mark.value)
        jdbc.update(UPDATE, params)
    }

    fun delete(workId: Long) {
        val params = MapSqlParameterSource()
            .addValue("workId", workId)
        jdbc.update(DELETE, params)
    }

    fun selectBySubjectId(subjectId: Long): List<Mark> {
        val params = MapSqlParameterSource()
            .addValue("subjectId", subjectId)
        return jdbc.query(SELECT_MARKS_BY_SUBJECT, params, MARK_MAPPER)
    }

    fun selectAverageBySubjectId(subjectId: Long): Mark? {
        val params = MapSqlParameterSource()
            .addValue("subjectId", subjectId)
        return jdbc.query(SELECT_AVERAGE_BY_SUBJECT, params, MARK_MAPPER).firstOrNull()
    }
}
