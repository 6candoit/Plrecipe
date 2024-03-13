package com.sixcandoit.plrecipe_member.command.security;

import com.sixcandoit.plrecipe_member.command.service.CommandMemberService;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    CommandMemberService commandMemberService;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    Environment env;

    @Autowired
    public SecurityConfig(
            CommandMemberService commandMemberService,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            Environment env) {
        this.commandMemberService = commandMemberService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.env = env;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(commandMemberService).passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.csrf((csrf) -> csrf.disable());

        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(new AntPathRequestMatcher("/register")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/searchMember/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/searchFollow/**")).permitAll()
        ).authenticationManager(authenticationManager);

        http.addFilter(getAuthenticationFilter(authenticationManager));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new AuthenticationFilter(authenticationManager, commandMemberService, env);
    }
}
