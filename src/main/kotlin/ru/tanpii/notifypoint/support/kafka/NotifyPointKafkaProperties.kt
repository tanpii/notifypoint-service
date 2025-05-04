package ru.tanpii.notifypoint.support.kafka

import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "kafka")
class NotifyPointKafkaProperties {
    var consumersEnabled: Boolean = false
    var clusters: Map<String,KafkaProperties> = mutableMapOf()
}
