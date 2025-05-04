package ru.tanpii.notifypoint

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka
import ru.tanpii.notifypoint.support.kafka.NotifyPointKafkaProperties

@EnableKafka
@EnableConfigurationProperties(NotifyPointKafkaProperties::class)
@SpringBootApplication
class NotifyPointApplication

fun main(args: Array<String>) {
	runApplication<NotifyPointApplication>(*args)
}
