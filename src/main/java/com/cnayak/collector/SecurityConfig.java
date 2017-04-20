package com.cnayak.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String USER = "USER";
	private static final String ADMIN = "ADMIN";
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests()
			.antMatchers("/metrics").hasRole(USER)
			.antMatchers("/metrics/*").hasRole(USER)
			.antMatchers("/admin").hasRole(ADMIN)
		.and()
			.formLogin();
	}
	
	@Autowired
	public void whatever(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("chandan").password("nayak").roles(USER)
		.and()
			.withUser("admin").password("nayak").roles(ADMIN);
	}
	
	
	
}
