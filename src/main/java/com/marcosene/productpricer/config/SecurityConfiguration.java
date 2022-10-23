package com.marcosene.productpricer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/api-docs/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/api/**").hasRole("API")
                .anyRequest().authenticated().and()
                .httpBasic().and()
                .formLogin().and()
                .logout();

        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }

    @Bean
    public UserDetailsManager users() {
        UserDetails apiUser = User.withUsername("api").password("{noop}Api@123").roles("API").build();

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(apiUser);
        return userDetailsManager;
    }
}
