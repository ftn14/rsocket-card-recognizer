package com.ftx.h1.inside

import com.ftx.h1.inside.client.RSocketClient
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.test.context.ActiveProfiles
import reactor.test.StepVerifier

@Suppress("EXPERIMENTAL_API_USAGE")
@TestConfiguration
@ActiveProfiles("test")
@SpringBootTest
class RSocketClientTest(@Autowired private val rSocketClient: RSocketClient) {

    @Test
    fun test() {
        val result = rSocketClient.sendHand("TEST_HAND")

        StepVerifier.create(result)
            .expectNextMatches { it == "received:TEST_HAND" }
            .verifyComplete()
    }
}