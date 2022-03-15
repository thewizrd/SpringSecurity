package com.cogent.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * ApplicationSecurityConfig
 *
 * @author bryan
 * @date Mar 7, 2022-3:04:44 PM
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails defaultUser = User.builder()
				.username("dave")
				.password(passwordEncoder.encode("password"))
				.roles("STUDENT")
				.build();
		
		return new InMemoryUserDetailsManager(defaultUser);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "index", "/css/*", "/js/*")
				.permitAll()
			.anyRequest()
				.authenticated()
			.and()
			.httpBasic();
	}
}
