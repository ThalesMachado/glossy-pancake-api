package com.example.glossypancake.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody

import com.example.glossypancake.models.AccessControl
import com.example.glossypancake.models.UserPassword
import com.example.glossypancake.models.UserLogin
import com.example.glossypancake.models.User
import com.example.glossypancake.controllers.PassportController
import com.example.glossypancake.repositories.UserRespository
import com.example.glossypancake.repositories.UserPassWordRespository

@RestController
@RequestMapping("/")
class PassportRestController {

    @Autowired
    private lateinit var userRepo: UserRespository

    @Autowired
    private lateinit var userPassRepo: UserPassWordRespository

    @PostMapping("/login")
    fun login(@RequestBody userLogin: UserLogin): AccessControl{
        //TODO: Change repository to Redis
        val user = userRepo.findOneByEmail(userLogin.email)
        val userPassword = userPassRepo.findOneByUser(user)
        return PassportController().validatePassword(userPassword, userLogin)
    }

    @PostMapping("/validate")
    fun validate(): UserPassword = PassportController().hashPassword("Teste");

}