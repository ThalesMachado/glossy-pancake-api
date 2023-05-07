package com.example.glossypancake.controllers

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
@EnableWebSecurity
class SecurityController{

    @Bean
    fun userDetailService(): UserDetailsService{
        val manager = InMemoryUserDetailsManager()
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build())
		return manager
    }
    
}