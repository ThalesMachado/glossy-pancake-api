package com.example.glossypancake.models

data class UserPassword(val hash: ByteArray, val salt: ByteArray)