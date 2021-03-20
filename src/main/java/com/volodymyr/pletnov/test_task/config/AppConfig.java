package com.volodymyr.pletnov.test_task.config;

import com.volodymyr.pletnov.test_task.interceptor.CustomRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	private final CustomRequestInterceptor customRequestInterceptor;

	public AppConfig(CustomRequestInterceptor customRequestInterceptor) {
		this.customRequestInterceptor = customRequestInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(customRequestInterceptor)
				.addPathPatterns("/**");;
	}
}
