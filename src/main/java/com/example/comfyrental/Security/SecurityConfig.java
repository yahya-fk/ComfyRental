package com.example.comfyrental.Security;

import com.example.comfyrental.Security.Entities.Admin;
import com.example.comfyrental.Security.Services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    //@Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    AdminService adminService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                ./*anyRequest()*/requestMatchers("/Auth/**","/local/**","/Reservations/**").permitAll().requestMatchers("/","/User/**","/Bill/**","/Booking/**","/Hosting/**","/Local/**").hasAnyRole("ADMIN")
                ).csrf(csrf -> csrf.disable()).formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/",true)
                        .permitAll()
                ).logout((logout) -> logout.permitAll())
                .exceptionHandling(exceptionHandling-> exceptionHandling.accessDeniedPage("/accessDenied"))
               ;

        return http.build();
    }
/*
    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN", "GUEST", "HOST").build(),
                User.withUsername("YahyaFEKRANE").password(passwordEncoder.encode("123")).roles("GUEST").build(),
                User.withUsername("RihabNIKH").password(passwordEncoder.encode("123")).roles("HOST").build()
        );
    }
*/
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Admin userEntity = adminService.FindUserById(username);
            if (userEntity == null) {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
            List<String> roleNames = adminService.listRole(userEntity);

            return org.springframework.security.core.userdetails.User.builder()
                    .username(userEntity.getUsername())
                    .password(userEntity.getPassword())
                    .roles(roleNames.toArray(new String[0]))
                    .build();
        };
    }
}


