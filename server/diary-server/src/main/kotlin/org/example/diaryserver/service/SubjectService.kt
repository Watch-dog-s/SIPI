package org.example.diaryserver.service

import org.example.diaryserver.dao.SubjectDao
import org.example.diaryserver.dto.request.CreateSubjectDTO
import org.example.diaryserver.model.Subject
import org.springframework.stereotype.Service

@Service
class SubjectService(
    private val subjectDao: SubjectDao
) {

    fun create(subject: CreateSubjectDTO) {
        subjectDao.insert(subject)
    }

    fun getAll(): List<Subject> {
        return subjectDao.selectAll()
    }

    fun update(id: Long, subject: CreateSubjectDTO) {
        subjectDao.getById(id) ?: throw IllegalArgumentException("Subject not found")
        subjectDao.update(id, subject)
    }

    fun delete(id: Long) {
        subjectDao.getById(id) ?: throw IllegalArgumentException("Subject not found")
        subjectDao.delete(id)
    }
}