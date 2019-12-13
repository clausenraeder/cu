package com.organizationX.cu.domain.people.repository

import com.organizationX.cu.domain.people.People
import org.springframework.data.jpa.repository.JpaRepository

interface PeopleRepository : JpaRepository<People, Long> {

}