package org.example.diaryserver.controller

import org.example.diaryserver.dto.request.CreateMarkDTO
import org.example.diaryserver.model.Mark
import org.example.diaryserver.service.MarkService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/mark")
class MarkController(
    private val markService: MarkService
) {
    companion object {
        private const val TOKEN: String = "Authorization"
    }

    @PostMapping
    fun create(
        @RequestHeader(TOKEN) token: String,
        @RequestBody mark: CreateMarkDTO
    ) {
        markService.create(mark)
    }

    @PutMapping
    fun update(
        @RequestHeader(TOKEN) token: String,
        @RequestBody mark: CreateMarkDTO
    ) {
        markService.update(mark)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ) {
        markService.delete(id)
    }

    @GetMapping("/{id}")
    fun getById(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ): Mark? {
        return markService.getById(id)
    }

    @GetMapping("/subject/{id}/avg")
    fun getByIdAverage(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ): Mark? {
        return markService.getAverageBySubjectId(id)
    }

    @GetMapping("/subject/{id}")
    fun getByIdSubject(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ): List<Mark> {
        return markService.getBySubjectId(id)
    }
}