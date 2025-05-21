package org.example.diaryserver.service

import org.example.diaryserver.client.UserClient
import org.example.diaryserver.dao.GroupDao
import org.example.diaryserver.dao.ScheduleDao
import org.example.diaryserver.dto.request.CreateEventDTO
import org.example.diaryserver.model.Event
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class ScheduleService(
    private val scheduleDao: ScheduleDao,
    private val groupDao: GroupDao,
    private val userClient: UserClient
) {
    fun getSchedule(token: String, date: OffsetDateTime): List<Event> {
        val userId = userClient.getUserIdByToken(token)
        val group = groupDao.getUserGroups(userId).firstOrNull()

        return scheduleDao.getByDateAndId(date, group!!.id)
    }

    fun createEvent(request: CreateEventDTO) {
        scheduleDao.createEvent(request)
    }
}