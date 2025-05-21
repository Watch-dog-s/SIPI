package org.example.diaryserver.dao

import org.example.diaryserver.dto.request.CreateEventDTO
import org.example.diaryserver.model.Event
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
                id,
                group_id,
                start_time,
                end_time,
                name
            from event
            where group_id = :group_id
                AND (
                    DATE(start_time) = DATE(:dateTime)
                    OR DATE(end_time) = DATE(:dateTime)
                    OR (
                        DATE(start_time) < DATE(:dateTime) 
                        AND DATE(end_time) > DATE(:dateTime)
                    )
                )
        """

        private val EVENT_MAPPER = RowMapper { rs, _ ->
            Event(
                id = rs.getLong("id"),
                groupId = rs.getString("group_id"),
                startTime = rs.getObject("start_time", OffsetDateTime::class.java),
                endTime = rs.getObject("end_time", OffsetDateTime::class.java),
                name = rs.getString("name")
            )
        }
    }


    fun getByDateAndId(date: OffsetDateTime, id: Long): List<Event> {
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