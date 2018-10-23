package com.baeldung.um.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



@Configuration
@ComponentScan({ "com.baeldung.um.web", "com.baeldung.common.web" })
@EnableWebMvc
public class UmWebConfig extends WebMvcConfigurationSupport {

    public UmWebConfig() {
        super();
    }
    
    // configuration it used to formatted response to xml or json
    
//    @Override
//    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
////    	// TODO Auto-generated method stub
////    	super.extendMessageConverters(converters);
//    	   final Optional<HttpMessageConverter<?>> jsonConverterFound = converters.stream().filter(c -> c instanceof MappingJackson2HttpMessageConverter).findFirst();
//           if (jsonConverterFound.isPresent()) {
//               final AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) jsonConverterFound.get();
//               converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
//               converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//           }
//           final Optional<HttpMessageConverter<?>> xmlConverterFound = converters.stream().filter(c -> c instanceof MappingJackson2XmlHttpMessageConverter).findFirst();
//           if (xmlConverterFound.isPresent()) {
//               final MappingJackson2XmlHttpMessageConverter converter = (MappingJackson2XmlHttpMessageConverter) xmlConverterFound.get();
//               converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
//               converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//           }
//    }

  
}
