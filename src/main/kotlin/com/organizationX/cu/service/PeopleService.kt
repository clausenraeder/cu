package com.organizationX.cu.service

import com.organizationX.cu.domain.people.People
import com.organizationX.cu.domain.people.repository.PeopleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PeopleService (
      @field:Autowired
      private val peopleRepository: PeopleRepository
                    ){

    fun read(id: Long): Optional<People> = peopleRepository.findById(id)
    fun getAll(): List<People> = peopleRepository.findAll().toList()
    fun save(people: People) = peopleRepository.save(people)
    fun deleteById(id: Long) = peopleRepository.deleteById(id)
    fun delete(people: People) = peopleRepository.delete(people)
}