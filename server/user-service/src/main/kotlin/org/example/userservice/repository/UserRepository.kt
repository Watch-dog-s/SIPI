package org.example.userservice.repository

import org.example.userservice.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun existsByEmail(username: String): Boolean
    fun getUserIdByUsername(username: String): User?
}