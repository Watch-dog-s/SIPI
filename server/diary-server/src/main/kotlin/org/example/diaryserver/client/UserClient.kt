package org.example.diaryserver.client

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class UserClient(
    private val webClient: WebClient
) {
    fun getUserIdByToken(token: String): Long {
        return webClient.get()
            .uri("/api/v1/auth/token")
            .header("Authorization", token)
            .retrieve()
            .bodyToMono(Long::class.java)
            .block() ?: throw RuntimeException("User not found")
    }
}
