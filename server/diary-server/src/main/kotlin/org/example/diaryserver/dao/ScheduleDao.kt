package org.example.diaryserver.dao

import org.example.diaryserver.dto.request.CreateEventDTO
import org.example.diaryserver.dto.response.EventResponse
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class ScheduleDao(
    private val jdbc: NamedParameterJdbcTemplate
) {
    companion object {
        private const val INSERT = """
            insert into event(group_id, start_time, end_time, name) 
            values (:group_id, :start_time, :end_time, :name)
            """

        private const val SELECT = """
            select 
                e.id,
                e.group_id,
                e.start_time,
                e.end_time,
                e.name
                e.place
                t.name as teacher_name,
                s.name as subject_name
            from event e
            LEFT JOIN subject s on e.subject_id = s.id
            LEFT JOIN teacher t on e.teacher_id = t.id
            where e.group_id = :group_id
                AND (
                    DATE(e.start_time) = DATE(:dateTime)
                    OR DATE(e.end_time) = DATE(:dateTime)
                    OR (
                        DATE(e.start_time) < DATE(:dateTime) 
                        AND DATE(e.end_time) > DATE(:dateTime)
                    )
                )
        """

        private val EVENT_MAPPER = RowMapper { rs, _ ->
            EventResponse(
                id = rs.getLong("id"),
                groupId = rs.getString("group_id"),
                startTime = rs.getObject("start_time", OffsetDateTime::class.java),
                endTime = rs.getObject("end_time", OffsetDateTime::class.java),
                name = rs.getString("name"),
                subjectName = rs.getString("subject_name"),
                place = rs.getString("place"),
                teacherName = rs.getString("teacher_name"),
            )
        }
    }


    fun getByDateAndId(date: OffsetDateTime, id: Long): List<EventResponse> {
        val params = MapSqlParameterSource()
            .addValue("group_id", id)
            .addValue("dateTime", date)

        return jdbc.query(
            SELECT,
            params,
            EVENT_MAPPER
        )
    }

    fun createEvent(event: CreateEventDTO) {
        val params = MapSqlParameterSource()
            .addValue("group_id", event.groupId)
            .addValue("start_time", event.startTime)
            .addValue("end_time", event.endTime)
            .addValue("name", event.name)

        jdbc.update(INSERT, params)
    }
}