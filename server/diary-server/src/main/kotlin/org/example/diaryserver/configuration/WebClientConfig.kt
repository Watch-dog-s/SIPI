package org.example.diaryserver.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig(
    @Value("\${USER_SERVICE_URL}") private val baseUrl: String
) {
    @Bean
    fun webClient(): WebClient =
        WebClient.builder()
            .baseUrl(baseUrl)
            .build()
}
