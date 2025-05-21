package org.example.diaryserver.controller

import org.example.diaryserver.dto.request.CreateWorkDTO
import org.example.diaryserver.model.Work
import org.example.diaryserver.service.WorkService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/work")
class WorkController(
    private val workService: WorkService
) {
    companion object {
        private const val TOKEN: String = "Authorization"
    }

    @PostMapping
    fun createWork(
        @RequestHeader(TOKEN) token: String,
        @RequestBody work: CreateWorkDTO
    ) {
        workService.createWork(token, work)
    }

    @DeleteMapping("/{id}")
    fun deleteWork(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ) {
        workService.deleteWork(token, id)
    }

    @PutMapping("/{id}")
    fun updateWork(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long,
        @RequestBody work: CreateWorkDTO
    ) {
        workService.updateWork(token, id, work)
    }

    @GetMapping("/{id}")
    fun getWork(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ): Work? {
        return workService.getById(id)
    }
}