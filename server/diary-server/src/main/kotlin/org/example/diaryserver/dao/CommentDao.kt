package org.example.diaryserver.dao

import org.example.diaryserver.dto.request.CreateCommentDTO
import org.example.diaryserver.model.Comment
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CommentDao(
    private val jdbc: NamedParameterJdbcTemplate
) {
    companion object {
        private const val INSERT = """
            insert into comment(work_id, text) 
            values (:workId, :text)
            """

        private const val SELECT_BY_WORK_ID = """
            select 
                work_id,
                text
            from comment
            where work_id = :workId
        """

        private const val UPDATE = """
            update comment
            set text = :text
            where work_id = :workId
        """

        private const val DELETE = """
            delete from comment
            where work_id = :workId
        """

        private const val SELECT_BY_SUBJECT = """
            select 
                c.work_id,
                c.text
            from comment c
            join work w on w.id = c.work_id
            where w.subject_id = :subjectId
        """

        private val COMMENT_MAPPER = RowMapper { rs, _ ->
            Comment(
                workId = rs.getLong("work_id"),
                text = rs.getString("text")
            )
        }
    }

    fun insert(comment: CreateCommentDTO) {
        val params = MapSqlParameterSource()
            .addValue("workId", comment.workId)
            .addValue("text", comment.text)
        jdbc.update(INSERT, params)
    }

    fun selectByWorkId(workId: Long): Comment? {
        return jdbc.query(
            SELECT_BY_WORK_ID,
            mapOf("workId" to workId),
            COMMENT_MAPPER
        ).firstOrNull()
    }

    fun update(comment: CreateCommentDTO) {
        val params = MapSqlParameterSource()
            .addValue("workId", comment.workId)
            .addValue("text", comment.text)
        jdbc.update(UPDATE, params)
    }

    fun delete(workId: Long) {
        val params = MapSqlParameterSource()
            .addValue("workId", workId)
        jdbc.update(DELETE, params)
    }

    fun selectBySubjectId(subjectId: Long): List<Comment> {
        val params = MapSqlParameterSource()
            .addValue("subjectId", subjectId)
        return jdbc.query(SELECT_BY_SUBJECT, params, COMMENT_MAPPER)
    }
} 