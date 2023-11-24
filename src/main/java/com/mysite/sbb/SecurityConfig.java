package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration  // 환경설정 파일
@EnableWebSecurity  // 모든 요청 URL이 스프링 시큐리티의 제어를 받도록
public class SecurityConfig {
    @Bean   // SecurityFilterChain 빈을 생성하여 시큐리티 세부설정
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                .requestMatchers(
                new AntPathRequestMatcher("/**")).permitAll())
                .csrf((csrf)->csrf
                .ignoringRequestMatchers(
                        new AntPathRequestMatcher("/h2-console/**")))    // h2 console 예외처리 - CSRF 검증x
                .headers((headers)->headers
                .addHeaderWriter(new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))    // 깨짐방지

                .formLogin((formLogin) ->formLogin
                .loginPage("/user/login")
                .defaultSuccessUrl("/")) // 성공 시 루트페이지로

                .logout((logout) ->logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")  // 로그아웃 성공 시 루트페이지로
                .invalidateHttpSession(true))

        ;   // 모든 인증되지 않은 요청을 허락
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() { // 비밀번호 암호화
        return new BCryptPasswordEncoder();
    }

    @Bean   // AuthenticationManager : 스프링 시큐리티의 인증 담당
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}