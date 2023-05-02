package com.example.glossypancake.api

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.example.glossypancake.models.User
import com.example.glossypancake.controllers.UserController
import com.example.glossypancake.repositories.UserRespository

@RestController
@RequestMapping("/user")
class UserRestController{

    @Autowired
    private lateinit var userRepo: UserRespository
    
    @PostMapping
    fun createUser(@RequestBody user: User): User = userRepo.insert(user)
}