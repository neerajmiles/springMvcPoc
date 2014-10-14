package com.miles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by Neeraj on 9/29/2014.
 */
@Configuration
@Import(HibernateConfig.class)
@ComponentScan(basePackages = { "com.miles.command", "com.miles.dao",
		"com.miles.service", "com.miles.controller" })
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {

	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry
	 * registry) {
	 * registry.addResourceHandler("/resources/**").addResourceLocations
	 * ("/resources/");
	 * registry.addResourceHandler("/assets/**").addResourceLocations
	 * ("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
	 * registry
	 * .addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod
	 * (31556926);
	 * registry.addResourceHandler("/img/**").addResourceLocations("/img/"
	 * ).setCachePeriod(31556926);
	 * registry.addResourceHandler("/js/**").addResourceLocations
	 * ("/js/").setCachePeriod(31556926); }
	 */

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/stylesheets/**")
				.addResourceLocations("classpath:/stylesheets/")
				.setCachePeriod(31556926);

		registry.addResourceHandler("/images/**")
				.addResourceLocations("classpath:/images/")
				.setCachePeriod(31556926);

		registry.addResourceHandler("/javascripts/**")
				.addResourceLocations("classpath:/javascripts/")
				.setCachePeriod(31556926);

		registry.addResourceHandler("/fonts/**")
				.addResourceLocations("classpath:/fonts/")
				.setCachePeriod(31556926);

	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	/*
	 * @Bean public ViewResolver internalResourceViewResolver() { final
	 * InternalResourceViewResolver ret = new InternalResourceViewResolver();
	 * //ret.setOrder(2); ret.setViewClass(JstlView.class);
	 * ret.setPrefix("/WEB-INF/jsp/"); ret.setSuffix(".jsp"); return ret; }
	 */

}
