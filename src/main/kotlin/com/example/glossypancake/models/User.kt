package com.example.glossypancake.models

import java.util.Date
import java.time.LocalDate
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import com.example.glossypancake.controllers.PassportController

@Document("User")
data class User(val name: String, val email:String, val password: String){
    @Id lateinit var id: String
    val userPassword: UserPassword
    val createdAt: Date

    init{
        createdAt = Date()
        userPassword = PassportController().hashPassword(password)
    }

}