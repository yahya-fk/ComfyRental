package com.example.comfyrental.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
@AllArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig{
    PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/userRegister").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");
        return httpSecurity.build();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN","GUEST","HOST").build(),
                User.withUsername("YahyaFEKRANE").password(passwordEncoder.encode("123")).roles("GUEST").build(),
                User.withUsername("RihabNIKH").password(passwordEncoder.encode("123")).roles("HOST").build());
    }
}
