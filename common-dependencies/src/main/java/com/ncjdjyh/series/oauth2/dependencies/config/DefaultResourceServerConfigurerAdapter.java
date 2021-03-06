package com.ncjdjyh.series.oauth2.dependencies.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

@Slf4j
public class DefaultResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {
	@Autowired
	private OAuth2WebSecurityExpressionHandler expressionHandler;

	@Bean
	public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
		OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
		expressionHandler.setApplicationContext(applicationContext);
		return expressionHandler;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.expressionHandler(expressionHandler);
	}

	@Override
	@SneakyThrows
	public void configure(HttpSecurity http) {
		http.
                csrf().disable()
				.authorizeRequests()
				.antMatchers("/actuator/**").permitAll()
				.anyRequest()
				.access("@rbacService.hasPermission(request, authentication)");
	}
}
