package com.cts.employees.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// authentication

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	// authorization

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer
				.requestMatchers(HttpMethod.GET, "/employees/findall").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/employees/findbyid/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/employees/save").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/employees/update/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/employees/delete/**").hasRole("ADMIN"));

		http.httpBasic(Customizer.withDefaults()); // form-based authentication
		http.csrf(csrf -> csrf.disable()); // disable csrf, by default csrf is enabled hence
		// POST & PUT operations are not allowed

		return http.build();
	}

	//In Memory Authentication
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsManager() { UserDetails
	 * raza = User.builder() .username("raza") .password("{noop}razapass")
	 * .roles("EMPLOYEE") .build();
	 * 
	 * UserDetails mary = User.builder() .username("mary")
	 * .password("{noop}marypass") .roles("MANAGER", "EMPLOYEE") .build();
	 * 
	 * UserDetails susan = User.builder() .username("susan")
	 * .password("{noop}susanpass") .roles("ADMIN", "MANAGER", "EMPLOYEE") .build();
	 * 
	 * return new InMemoryUserDetailsManager(raza, mary, susan); }
	 */
	
	
}
