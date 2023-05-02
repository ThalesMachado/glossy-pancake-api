package com.example.glossypancake.models

import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.annotation.Id

@Document("UserPassword")
data class UserPassword(val hash: ByteArray, val salt: ByteArray){
    @Id
    var id: String? = null

    @DBRef
    var user: User? = null
    var createdAt: Date

    init{
        createdAt = Date()
    }

    constructor(
        hash: ByteArray,
        salt: ByteArray,
        createdAt: Date,
        id: String
    ): this(hash, salt){
        this.id = id
        this.createdAt = createdAt
    }
}
    