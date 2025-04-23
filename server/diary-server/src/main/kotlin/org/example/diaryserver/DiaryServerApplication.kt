package org.example.diaryserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DiaryServerApplication

fun main(args: Array<String>) {
	runApplication<DiaryServerApplication>(*args)
}
