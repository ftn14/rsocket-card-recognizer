package com.ftx.h1.inside.client

import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.messaging.rsocket.retrieveAndAwait
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class RSocketClient(private val requester: RSocketRequester) {

    fun sendHand(hand: String): Mono<String> = requester
            .route("HANDS")
            .data(hand)
            .retrieveMono(String::class.java)

    suspend fun sendHand2(hand: String): String =
        requester.route("HANDS").data(hand).retrieveAndAwait()
}
