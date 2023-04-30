package com.example.glossypancake

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RestController("/")
class PassportController 

    @PostMapping("/login")
    fun login(): AccessControl{
        val access: AccessControl = AccessControl("hashsupercomplexo", true);
        return access;
    }

    @GetMapping("/validate")
    fun validate(){
        return
    }
