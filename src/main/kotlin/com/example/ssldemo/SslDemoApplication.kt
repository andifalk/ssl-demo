package com.example.ssldemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SslDemoApplication

fun main(args: Array<String>) {
    runApplication<SslDemoApplication>(*args)
}
