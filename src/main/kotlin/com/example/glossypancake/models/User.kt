package com.example.glossypancake.models

import java.util.Date
import java.time.LocalDate
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.glossypancake.controllers.PassportController


@Document("User")
data class User(var name: String, @Indexed(unique=true) var email:String, var password: String){

    @JsonIgnore
    @Id
    lateinit var id: String

    var createdAt: Date = Date()

    constructor(
        name: String,
        email: String,
        password: String,
        id: String,
        createdAt: Date 
        ): this(name, email, password){
            this.id = id
            this.createdAt = createdAt
        }
}