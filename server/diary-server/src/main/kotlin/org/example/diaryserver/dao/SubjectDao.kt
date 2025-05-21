package org.example.diaryserver.dao

import org.example.diaryserver.dto.request.CreateSubjectDTO
import org.example.diaryserver.model.Subject
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class SubjectDao(
    private val jdbc: NamedParameterJdbcTemplate
) {

    companion object {
        private const val INSERT = """
            insert into subject(name) 
            values (:name)
            """

        private const val SELECT_ALL_FROM_SUBJECT = """
            select 
                id,
                name
            from subject
        """

        private const val UPDATE = """
            update subject
            set name = :name
            where id = :id
        """

        private const val DELETE = """
            delete from subject
            where id = :id
        """

        private const val SELECT_BY_ID = """
            select 
                id,
                name
            from subject
            where id = :id
        """

        private val SUBJECT_MAPPER = RowMapper { rs, _ ->
            Subject(
                id = rs.getLong("id"),
                name = rs.getString("name")
            )
        }
    }

    fun selectAll(): List<Subject> {
        return jdbc.query(SELECT_ALL_FROM_SUBJECT, SUBJECT_MAPPER)
    }

    fun insert(subject: CreateSubjectDTO) {
        val params = MapSqlParameterSource()
            .addValue("name", subject.name)
        jdbc.update(INSERT, params)
    }

    fun update(id: Long, subject: CreateSubjectDTO) {
        val params = MapSqlParameterSource()
            .addValue("id", id)
            .addValue("name", subject.name)
        jdbc.update(UPDATE, params)
    }

    fun delete(id: Long) {
        val params = MapSqlParameterSource()
            .addValue("id", id)
        jdbc.update(DELETE, params)
    }

    fun getById(id: Long): Subject? {
        return jdbc.query(
            SELECT_BY_ID,
            MapSqlParameterSource().addValue("id", id),
            SUBJECT_MAPPER
        ).firstOrNull()
    }
}