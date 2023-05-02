package com.example.glossypancake.controllers

import com.example.glossypancake.models.User
import com.example.glossypancake.models.UserPassword
import com.example.glossypancake.repositories.UserRespository

open class UserController(val userRepo: UserRespository){

    open fun createUser(user: User): User{

        val createdUser = userRepo.insert(user)
        return createdUser
    }

}


