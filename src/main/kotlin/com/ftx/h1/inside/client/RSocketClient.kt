package com.ftx.h1.inside.client

import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class RSocketClient(private val requester: RSocketRequester) {

    fun sendHand(hand: String): Mono<String> = requester
            .route("HANDS")
            .data(hand)
            .retrieveMono(String::class.java)

}