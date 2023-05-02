package com.example.glossypancake.controllers

import java.security.SecureRandom
import kotlin.byteArrayOf
import javax.crypto.spec.PBEKeySpec
import javax.crypto.SecretKeyFactory

import com.example.glossypancake.models.UserPassword
import com.example.glossypancake.models.UserLogin
import com.example.glossypancake.models.AccessControl

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

    fun validatePassword(userPassword: UserPassword, userLogin: UserLogin): AccessControl{
        val spec = PBEKeySpec(userLogin.password.toCharArray(), userPassword.salt, 65536, 128)
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
    
        val hash = factory.generateSecret(spec).getEncoded();

        var accessControl: AccessControl
        if(hash == userPassword.hash){
            accessControl = AccessControl("acessHash", true)
        } else {
            accessControl = AccessControl("", false)
        }
        return accessControl
    }
}




