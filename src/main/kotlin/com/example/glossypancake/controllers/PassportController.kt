package com.example.glossypancake.controllers

import java.security.SecureRandom
import kotlin.byteArrayOf
import javax.crypto.spec.PBEKeySpec
import javax.crypto.SecretKeyFactory

import com.example.glossypancake.models.UserPassword

class PassportController {
    public fun hashPassword(visiblePassword: String): UserPassword{
        val random = SecureRandom()
        val salt = byteArrayOf(16)
        random.nextBytes(salt)
        val spec = PBEKeySpec(visiblePassword.toCharArray(), salt, 65536, 128)
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
    
        val hash = factory.generateSecret(spec).getEncoded();
        return UserPassword(hash, salt)
    }
}




