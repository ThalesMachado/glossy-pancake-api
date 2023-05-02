package com.example.glossypancake.controllers

import com.example.glossypancake.repositories.UserPassWordRespository
import com.example.glossypancake.models.UserPassword

open class UserPasswordController(val userPassRepo: UserPassWordRespository){

    open fun createUserPassword(userPassword: UserPassword): UserPassword{
        return userPassRepo.insert(userPassword)
    }

}

