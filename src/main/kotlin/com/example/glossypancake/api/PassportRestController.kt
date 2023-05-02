package com.example.glossypancake.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

import com.example.glossypancake.models.AccessControl
import com.example.glossypancake.models.UserPassword
import com.example.glossypancake.controllers.PassportController

@RestController("/")
class PassportRestController {

    @PostMapping("/login")
    fun login(): AccessControl{
        val access: AccessControl = AccessControl("hashsupercomplexo", true);
        return access;
    }

    @PostMapping("/validate")
    fun validate(): UserPassword = PassportController().hashPassword("Teste");

}