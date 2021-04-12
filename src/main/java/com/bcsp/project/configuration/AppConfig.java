package com.bcsp.project.configuration;

import com.bcsp.project.converter.RoleToUserProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bcsp.project")
public class AppConfig extends WebMvcConfigurerAdapter{
	///
	private static final Charset UTF8 = Charset.forName("UTF-8");

	//
	@Bean(name="multipartResolver")
	public StandardServletMultipartResolver resolver(){
		return new StandardServletMultipartResolver();
	}

	// Config UTF-8 Encoding.
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
		converters.add(stringConverter);
		// Add other converters ...
	}


	///
	
	
	@Autowired
	RoleToUserProfileConverter roleToUserProfileConverter;
	

	/**
     * Configure ViewResolvers to deliver preferred views.
     */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	
	/**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");

    }
    
    /**
     * Configure Converter to be used.
     * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
    }
	

    /**
     * Configure MessageSource to lookup any validation/error message in internationalized property files
     */
    @Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
    
    /**Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
     * This is a workaround for this issue.
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }


    /// view config
	/*
	 * Configure ContentNegotiationManager
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(
				MediaType.TEXT_HTML);
	}


	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}



	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB

	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");

		//Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSizePerFile(419430400);//5MB

		//You may also set other available properties.
		//max_allowed_packet=419430400;
		//maxUploadSizeInMb=419430400;

		//SET GLOBAL max_allowed_packet=1073741824;
		//maxUploadSizeInMb=5242880;
		//multipart.max-file-size=100MB
		//multipart.max-request-size=100MB

		return resolver;
	}



}

