package com.ftx.h1.inside.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("spring.rsocket.server")
data class RSocketProperties(val host: String, val port: String)