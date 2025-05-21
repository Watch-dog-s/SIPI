package org.example.diaryserver.controller

import org.example.diaryserver.dto.request.CreateSubjectDTO
import org.example.diaryserver.model.Subject
import org.example.diaryserver.service.SubjectService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/subject")
class SubjectController(
    private val subjectService: SubjectService
) {
    companion object {
        private const val TOKEN: String = "Authorization"
    }

    @PostMapping
    fun createSubject(
        @RequestHeader(TOKEN) token: String,
        @RequestBody subject: CreateSubjectDTO
    ) {
        subjectService.create(subject)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ) {
        subjectService.delete(id)
    }

    @PutMapping("/{id}")
    fun update(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long,
        @RequestBody subject: CreateSubjectDTO
    ) {
        subjectService.update(id, subject)
    }

    @GetMapping
    fun getAllSubjects(
        @RequestHeader(TOKEN) token: String
    ): List<Subject> {
        return subjectService.getAll()
    }
}