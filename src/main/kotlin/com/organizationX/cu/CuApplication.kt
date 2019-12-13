package com.organizationX.cu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CuApplication

fun main(args: Array<String>) {
	runApplication<CuApplication>(*args)
}
