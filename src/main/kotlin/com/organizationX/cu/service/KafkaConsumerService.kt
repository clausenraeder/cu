package com.organizationX.cu.service

import com.google.gson.Gson
import com.organizationX.cu.domain.people.People
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class KafkaConsumerService {

    @Autowired
    private lateinit var peopleService: PeopleService

    @KafkaListener(topics = ["\${kafka_topic}"], groupId = "\${Kafka_group_id}")
    fun consume(message: String?) {
        logger.info(String.format("$$ -> Consumed Message -> %s", message))
        peopleService.save(Gson().fromJson(message, People::class.java))
    }


    companion object : KLogging()
}