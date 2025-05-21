package org.example.diaryserver.service

import org.example.diaryserver.dao.CommentDao
import org.example.diaryserver.dto.request.CreateCommentDTO
import org.example.diaryserver.model.Comment
import org.springframework.stereotype.Service

@Service
class CommentService(
    private val commentDao: CommentDao
) {
    fun create(comment: CreateCommentDTO) {
        commentDao.insert(comment)
    }

    fun getById(workId: Long): Comment? {
        return commentDao.selectByWorkId(workId)
    }

    fun update(comment: CreateCommentDTO) {
        commentDao.selectByWorkId(comment.workId) ?: throw IllegalArgumentException("Comment not found")
        commentDao.update(comment)
    }

    fun delete(workId: Long) {
        commentDao.selectByWorkId(workId) ?: throw IllegalArgumentException("Comment not found")
        commentDao.delete(workId)
    }

    fun getBySubjectId(subjectId: Long): List<Comment> {
        return commentDao.selectBySubjectId(subjectId)
    }
} 