package com.ftx.h1.inside.client

import org.springframework.messaging.rsocket.RSocketRequester
import reactor.core.publisher.Mono

class RSocketClient(private val requester: RSocketRequester) {

    fun sendHand(hand: String): Mono<String> = requester
            .route("hands")
            .data(hand)
            .retrieveMono(String::class.java)
}