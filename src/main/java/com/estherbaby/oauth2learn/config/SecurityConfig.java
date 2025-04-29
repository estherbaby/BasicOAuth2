package com.estherbaby.oauth2learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers("/whoami").permitAll()
                    .requestMatchers("/", "/secured", "/logout-link").authenticated()
            )
            .oauth2Login(Customizer.withDefaults()) // uses default login behavior
            .logout(logout -> logout
            	    .logoutSuccessUrl("/whoami") // redirect to /whoami
            	    .invalidateHttpSession(true)
            	    .clearAuthentication(true)
            	    .deleteCookies("JSESSIONID")
            	    );

        return http.build();
    }
}
