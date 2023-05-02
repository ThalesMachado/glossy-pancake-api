package com.example.glossypancake.api

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.example.glossypancake.models.User
import com.example.glossypancake.controllers.UserController
import com.example.glossypancake.controllers.PassportController
import com.example.glossypancake.controllers.UserPasswordController
import com.example.glossypancake.repositories.UserRespository
import com.example.glossypancake.repositories.UserPassWordRespository

@RestController
@RequestMapping("/user")
class UserRestController{

    @Autowired
    private lateinit var userRepo: UserRespository

    @Autowired
    private lateinit var userPassRepo: UserPassWordRespository
    
    @PostMapping
    fun createUser(@RequestBody user: User): User{
        val createdUser = UserController(userRepo).createUser(user)
        val userPassword = PassportController().hashPassword(user.password)
        userPassword.user = createdUser
        val createdUserPassword = UserPasswordController(userPassRepo).createUserPassword(userPassword)
        return createdUser

    }
}