package com.ftx.h1.inside

import com.ftx.h1.inside.client.RSocketClient
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.test.context.ActiveProfiles

@Suppress("EXPERIMENTAL_API_USAGE")
@TestConfiguration
@ActiveProfiles("test")
@SpringBootTest
class RSocketClientTest(private val rSocketClient: RSocketClient) {

    @Test
    fun test() {
        rSocketClient.sendHand("TEST_HAND")
    }
}