package com.example.ssldemo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.headers().httpStrictTransportSecurity().disable()
                .and().httpBasic().and().formLogin()
                .and().authorizeRequests().anyRequest().authenticated()
    }

    @Bean
    fun myUserDetails(): UserDetailsService = InMemoryUserDetailsManager (
        User.withUsername("user")
                .password("secret")
                .passwordEncoder { passwordEncoder().encode(it) }
                .roles("USER")
                .build()
    )

    @Bean
    fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}
