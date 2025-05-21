package org.example.diaryserver.controller

import org.example.diaryserver.dto.request.CreateCommentDTO
import org.example.diaryserver.model.Comment
import org.example.diaryserver.service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/comment")
class CommentController(
    private val commentService: CommentService
) {
    companion object {
        private const val TOKEN: String = "Authorization"
    }

    @PostMapping
    fun create(
        @RequestHeader(TOKEN) token: String,
        @RequestBody comment: CreateCommentDTO
    ) {
        commentService.create(comment)
    }

    @PutMapping
    fun update(
        @RequestHeader(TOKEN) token: String,
        @RequestBody comment: CreateCommentDTO
    ) {
        commentService.update(comment)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ) {
        commentService.delete(id)
    }

    @GetMapping("/{id}")
    fun getById(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ): Comment? {
        return commentService.getById(id)
    }

    @GetMapping("/subject/{id}")
    fun getBySubjectId(
        @RequestHeader(TOKEN) token: String,
        @PathVariable("id") id: Long
    ): List<Comment> {
        return commentService.getBySubjectId(id)
    }
} 