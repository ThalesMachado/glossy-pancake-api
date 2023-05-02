package com.example.glossypancake.controllers

import com.example.glossypancake.models.User
import com.example.glossypancake.repositories.UserRespository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

open class UserController{

    @Autowired
    private lateinit var userRepo: UserRespository


    open fun createUser(user: User): User{
        val createdUser = userRepo.insert(user)
        return createdUser
    }

}


