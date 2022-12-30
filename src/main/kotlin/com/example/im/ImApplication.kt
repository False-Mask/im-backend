package com.example.im

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.socket.config.annotation.EnableWebSocket

@SpringBootApplication
class ImApplication

fun main(args: Array<String>) {
    runApplication<ImApplication>(*args)
}
