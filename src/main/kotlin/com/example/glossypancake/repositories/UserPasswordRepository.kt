package com.example.glossypancake.repositories

import com.example.glossypancake.models.UserPassword
import com.example.glossypancake.models.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


interface UserPassWordRespository: MongoRepository<UserPassword, String>{

    fun findOneById(id: String): UserPassword
    fun findOneByUser(user: User): UserPassword
}
