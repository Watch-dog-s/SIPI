package org.example.diaryserver.service

import org.example.diaryserver.dao.WorkDao
import org.example.diaryserver.model.Work
import org.springframework.stereotype.Service

@Service
class WorkService(
    private val workDao: WorkDao
) {
    fun getById(id: Long): Work? {
        return workDao.getById(id);
    }
}