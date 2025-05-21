package org.example.userservice.service

import org.example.userservice.repository.UserRepository
import org.example.userservice.security.JwtTokenProvider
import org.springframework.stereotype.Service

@Service
class UserService(
    private val jwtTokenProvider: JwtTokenProvider,
    private val userRepository: UserRepository
) {

    fun getUserIdByToken(token: String): Long {
        val username = jwtTokenProvider.getUsername(token)
        
        return userRepository.getUserIdByUsername(username)!!.id!!
    }
}