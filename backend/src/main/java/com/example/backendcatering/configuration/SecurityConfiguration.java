package com.example.backendcatering.configuration;

import com.example.backendcatering.repository.UserRepository;
import com.example.backendcatering.security.JwtAuthenticationEntryPoint;
import com.example.backendcatering.security.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.backendcatering.constant.SecurityConstant.PUBLIC_URLS;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private JwtAuthorizationFilter jwtAuthorizationFilter;
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


    @Autowired
    public SecurityConfiguration( JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint){
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;

    }

 @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
     http.csrf().disable().cors().and()
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and().authorizeRequests().antMatchers(PUBLIC_URLS).permitAll()
             .anyRequest().authenticated();
     return http.build();
 }



}
