package com.example.speedrun.memo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	  
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
	    // csrf 비활성화
	    .csrf(csrf -> csrf.disable())
	    // H2 콘솔을 위한 헤더 설정
	    .headers(headers -> headers
	        .contentSecurityPolicy(csp -> csp
	            .policyDirectives("frame-ancestors 'self'")
	        )
	    )
	    .authorizeHttpRequests(auth -> auth
	        // H2 콘솔에 대한 접근 허용
	        .requestMatchers("/h2-console/**").permitAll()
	        // 특정 요청 보안 설정
	        .requestMatchers("/Admin/**").authenticated()
	        // permitAll() : 인증 없이 접근 허용 
	        .anyRequest().permitAll()	
	    );

	return http.build();
	}
 
}