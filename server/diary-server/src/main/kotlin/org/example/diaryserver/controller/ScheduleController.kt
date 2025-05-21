package org.example.diaryserver.controller

import org.example.diaryserver.dto.request.CreateEventDTO
import org.example.diaryserver.model.Event
import org.example.diaryserver.service.ScheduleService
import org.springframework.web.bind.annotation.*
import java.time.OffsetDateTime

@RestController
@RequestMapping("/api/v1/schedule")
class ScheduleController(
    private val scheduleService: ScheduleService
) {
    companion object {
        private const val TOKEN: String = "Authorization"
    }

    @GetMapping
    fun getScheduleForUser(
        @RequestHeader(TOKEN) token: String,
        @RequestParam("date") date: OffsetDateTime
    ): List<Event> {
        return scheduleService.getSchedule(token, date)
    }

    @PostMapping
    fun addEventForGroup(
        @RequestHeader(TOKEN) token: String,
        @RequestBody request: CreateEventDTO
    ) {
        scheduleService.createEvent(request)
    }
}