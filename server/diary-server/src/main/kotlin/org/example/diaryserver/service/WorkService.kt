package org.example.diaryserver.service

import org.example.diaryserver.client.UserClient
import org.example.diaryserver.dao.WorkDao
import org.example.diaryserver.dto.request.CreateWorkDTO
import org.example.diaryserver.model.Work
import org.springframework.stereotype.Service

@Service
class WorkService(
    private val workDao: WorkDao,
    private val userClient: UserClient
) {
    fun getById(id: Long): Work? {
        return workDao.getById(id);
    }

    fun createWork(token: String, work: CreateWorkDTO){
        val userId = userClient.getUserIdByToken(token)
        workDao.createWork(userId, work)
    }

    fun updateWork(token: String, id: Long, work: CreateWorkDTO) {
        val userId = userClient.getUserIdByToken(token)
        val existingWork = workDao.getById(id) ?: throw IllegalArgumentException("Work not found")
        if (existingWork.studentId != userId) {
            throw IllegalArgumentException("Not authorized to update this work")
        }
        workDao.updateWork(id, userId, work)
    }

    fun deleteWork(token: String, id: Long) {
        val userId = userClient.getUserIdByToken(token)
        val existingWork = workDao.getById(id) ?: throw IllegalArgumentException("Work not found")
        if (existingWork.studentId != userId) {
            throw IllegalArgumentException("Not authorized to delete this work")
        }
        workDao.deleteWork(id)
    }
}