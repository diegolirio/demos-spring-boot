package com.example.demonewrelic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoNewRelicApplication

fun main(args: Array<String>) {
	runApplication<DemoNewRelicApplication>(*args)
}
