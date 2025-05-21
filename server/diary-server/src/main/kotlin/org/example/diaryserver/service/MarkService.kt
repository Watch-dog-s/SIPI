package org.example.diaryserver.service

import org.example.diaryserver.client.UserClient
import org.example.diaryserver.dao.MarkDao
import org.example.diaryserver.dto.request.CreateMarkDTO
import org.example.diaryserver.model.Mark
import org.springframework.stereotype.Service

@Service
class MarkService(
    private val markDao: MarkDao,
    private val userClient: UserClient
) {
    fun create(mark: CreateMarkDTO) {
        markDao.insert(mark)
    }

    fun getById(id: Long): Mark? {
        return markDao.selectByWorkId(id)
    }

    fun update(mark: CreateMarkDTO) {
        markDao.selectByWorkId(mark.workId) ?: throw IllegalArgumentException("Mark not found")
        markDao.update(mark)
    }

    fun delete(workId: Long) {
        markDao.selectByWorkId(workId) ?: throw IllegalArgumentException("Mark not found")
        markDao.delete(workId)
    }

    fun getBySubjectId(subjectId: Long): List<Mark> {
        return markDao.selectBySubjectId(subjectId)
    }

    fun getAverageBySubjectId(subjectId: Long): Mark? {
        return markDao.selectAverageBySubjectId(subjectId)
    }
}