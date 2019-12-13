package com.organizationX.cu.controller

import com.google.gson.Gson
import com.organizationX.cu.domain.people.People
import com.organizationX.cu.service.KafkaProducerService
import com.organizationX.cu.service.PeopleService
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/people")
open class PeopleController {

    @Autowired
    private lateinit var people: PeopleService

    @Autowired
    private lateinit var kafkaProducerService: KafkaProducerService

    /**
     * Non verbose
     * */
    @GetMapping("/{id}")
    fun people(@PathVariable("id") id: Long) = people.read(id).get()

    @GetMapping
    fun peoples(): List<People> = people.getAll()

    @PostMapping
    fun create(@RequestBody payload: People) = people.save(payload)

    @PutMapping("/{id}")
    fun update(@RequestBody payload: People, @PathVariable("id") id: Long) = people.read(id).get()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = people.deleteById(id)


    @GetMapping("/kafka_people/{id}")
    fun kafka(@PathVariable("id") id: Long){
        var gson = Gson()
        logger.info( gson.toJson(people.read(id).get()))
        kafkaProducerService.sendMessage(gson.toJson(people.read(id).get()).toString())
    }

    companion object : KLogging()


}