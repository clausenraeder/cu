package com.organizationX.cu.service

import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service


@Service
class KafkaProducerService {

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    @Value("\${kafka_topic}")
    private lateinit var topic:String

    fun sendMessage(message: String?) {
        logger.info(String.format("#### -> Producing message -> %s", message))
        kafkaTemplate.send(topic, message)
    }


    companion object : KLogging()
}