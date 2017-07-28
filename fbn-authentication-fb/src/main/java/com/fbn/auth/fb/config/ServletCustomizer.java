package com.fbn.auth.fb.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.boot.web.servlet.ErrorPage;

@Configuration
public class ServletCustomizer {
	
	@Bean
	public EmbeddedServletContainerCustomizer customizer() {
		return container -> {
			container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/unauthenticated"));
		};
	}
}