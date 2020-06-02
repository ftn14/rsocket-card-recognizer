package com.ftx.h1.inside.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("h1.server")
data class RSocketProperties(val host: String, val port: String)