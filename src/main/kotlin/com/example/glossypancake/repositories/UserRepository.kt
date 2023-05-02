package com.example.glossypancake.repositories

import com.example.glossypancake.models.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository


interface UserRespository: MongoRepository<User, String>{

    fun findOneById(id: String): User
}

    