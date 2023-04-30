package com.example.glossypancake

data class User(val Name: String, val email:String, private val password: String, val createdAtTimestamp: String){}