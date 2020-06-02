package com.ftx.h1.inside

import com.ftx.h1.inside.client.RSocketClient
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.test.context.ActiveProfiles
import org.springframework.util.Assert
import reactor.test.StepVerifier

@Suppress("EXPERIMENTAL_API_USAGE")
@TestConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@SpringBootTest
class RSocketClientToServerITest(@Autowired private val rSocketClient: RSocketClient) {

    lateinit var rSocketRequester: RSocketRequester

    @BeforeAll
    fun setupOnce(
        @Autowired builder: RSocketRequester.Builder,
        @Value("\${h1.server.port}") port: Int
    ) {
        this.rSocketRequester = builder
            .connectTcp("localhost", port)
            .block() ?: throw RuntimeException("Error while creating RSocket request")
    }


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