package com.cts.library.config;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.cts.library.service.MyUserDetailsService;


@Configuration
public class SecurityConfig {



	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);

	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
//		authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

		return authProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(configurer->
		configurer
		.requestMatchers(HttpMethod.POST,"/books/addBook").hasRole("ADMIN")
		.requestMatchers(HttpMethod.DELETE,"/books/deleteBook/**").hasRole("ADMIN")
		.requestMatchers(HttpMethod.GET,"/books/getAvailableBooks").hasAnyRole("ADMIN","USER")
		.requestMatchers(HttpMethod.GET,"/books/getBorrowedBooks").hasRole("ADMIN")
		.requestMatchers(HttpMethod.PUT,"/books/borrowBook/**").hasRole("USER")
		.requestMatchers(HttpMethod.GET,"/books/getBookByTitle/**").hasRole("USER")
		.requestMatchers(HttpMethod.GET,"/users/getAllUsers").hasRole("ADMIN")
		.requestMatchers(HttpMethod.POST,"/users/createUser").hasRole("ADMIN"));
		httpSecurity.httpBasic(Customizer.withDefaults());
		httpSecurity.csrf(csrf->csrf.disable());
		return httpSecurity.build();
	}





}
