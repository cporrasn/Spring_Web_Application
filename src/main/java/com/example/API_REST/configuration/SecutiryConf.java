package com.example.API_REST.configuration;

import com.example.API_REST.services.AuthenticationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecutiryConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationServices service;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public BCryptPasswordEncoder passrowrdEncoder(){
         BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
         return encoder;
     }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auteh) throws Exception {
        auteh.userDetailsService(service).passwordEncoder(encoder);
    }
}
