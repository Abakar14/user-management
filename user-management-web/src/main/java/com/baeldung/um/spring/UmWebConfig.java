package com.baeldung.um.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;



@Configuration
@ComponentScan({ "com.baeldung.um.web", "com.baeldung.common.web" })
@EnableWebMvc
public class UmWebConfig extends WebMvcConfigurerAdapter {

    public UmWebConfig() {
        super();
    }
    
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {    
    	  final Optional<HttpMessageConverter<?>> jsonConverterFound = converters.stream().filter(c -> c instanceof MappingJackson2HttpMessageConverter).findFirst();
    	  if (jsonConverterFound.isPresent()) {
              final AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) jsonConverterFound.get();
              converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
              converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
          }
    	  
    	  
    }
    
  
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
    	return new LocalValidatorFactoryBean();
    }
    
    // configuration it used to formatted response to xml or json
    /*
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    	
    	super.extendMessageConverters(converters);
    	   final Optional<HttpMessageConverter<?>> jsonConverterFound = converters.stream().filter(c -> c instanceof MappingJackson2HttpMessageConverter).findFirst();
           if (jsonConverterFound.isPresent()) {
               final AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) jsonConverterFound.get();
               converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
               converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
           }
           final Optional<HttpMessageConverter<?>> xmlConverterFound = converters.stream().filter(c -> c instanceof MappingJackson2XmlHttpMessageConverter).findFirst();
           if (xmlConverterFound.isPresent()) {
               final MappingJackson2XmlHttpMessageConverter converter = (MappingJackson2XmlHttpMessageConverter) xmlConverterFound.get();
               converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
               converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
           }
    }*/

  
}
