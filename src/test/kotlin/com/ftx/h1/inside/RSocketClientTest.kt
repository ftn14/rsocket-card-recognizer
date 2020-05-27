package com.ftx.h1.inside

import com.ftx.h1.inside.client.RSocketClient
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.test.context.ActiveProfiles
import org.springframework.util.Assert
import reactor.test.StepVerifier

@Suppress("EXPERIMENTAL_API_USAGE")
@TestConfiguration
@ActiveProfiles("test")
@SpringBootTest
class RSocketClientTest(@Autowired private val rSocketClient: RSocketClient) {

    @Test
    fun test() {
        val result = rSocketClient.sendHand("test")
        println("result=$result")
        StepVerifier.create(result)
            .expectNextMatches { it == "result" }
            .verifyComplete()
        println("after step verifier")
    }

    @Test
    fun test2() = runBlocking {
        val result = rSocketClient.sendHand2("test")
        println("result=$result")
        Assert.isTrue(result.equals("result"), "incorrect result")
    }

    @Test
    fun test3() = runBlockingTest {
        val result = launch { rSocketClient.sendHand2("test") }
        println("result=${result.join()}")
        Assert.isTrue(result.equals("result"), "incorrect result")
    }
}