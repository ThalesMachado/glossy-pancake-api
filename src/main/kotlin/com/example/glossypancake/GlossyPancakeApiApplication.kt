package com.example.glossypancake

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@ComponentScan
@EnableMongoRepositories
class GlossyPancakeApiApplication

fun main(args: Array<String>) {
	runApplication<GlossyPancakeApiApplication>(*args)
}
