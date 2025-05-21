package org.example.userservice.controller

import org.example.userservice.dto.request.LoginRequest
import org.example.userservice.dto.request.RegisterRequest
import org.example.userservice.dto.response.AuthResponse
import org.example.userservice.entity.Token
import org.example.userservice.entity.User
import org.example.userservice.repository.TokenRepository
import org.example.userservice.repository.UserRepository
import org.example.userservice.security.JwtTokenProvider
import org.example.userservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val userRepository: UserRepository,
    private val tokenRepository: TokenRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val userService: UserService,
) {
    companion object {
        private const val TOKEN: String = "Authorization"
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): AuthResponse {
        if (userRepository.findByUsername(request.username) != null) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Username already exists")
        }
        if (userRepository.existsByEmail(request.email)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Email already registered")
        }

        val user = User(
            username = request.username,
            password = passwordEncoder.encode(request.password),
            email = request.email
        )
        val u = userRepository.save(user)

        val token = jwtTokenProvider.createToken(user.username!!)

        tokenRepository.save(Token(u.id!!, token))
        return AuthResponse(token)
    }


    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): AuthResponse {
        val user = userRepository.findByUsername(request.username)
            ?: throw RuntimeException("User not found")

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw RuntimeException("Invalid credentials")
        }

        val token = jwtTokenProvider.createToken(user.username!!)
        return AuthResponse(token)
    }

    @GetMapping("/token")
    fun getUserIdByToken(@RequestHeader(TOKEN) authHeader: String): Long {
        val token = authHeader.substring(7)
        return userService.getUserIdByToken(token)
    }
}
