package com.yingxiaotong.restspringmvc.controller.config;

import com.yingxiaotong.restspringmvc.http.message.PropertiesPersonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 自定义配置
 * */
@Configuration
public class MyWebMvcConfigurer  implements WebMvcConfigurer {

    public  void  extendMessageConverters(List<HttpMessageConverter<?>> converters){
//        converters.set(0,new MappingJackson2HttpMessageConverter());   //MappingJackson2XmlHttpMessageConverter
//        converters.add( new MappingJackson2HttpMessageConverter());
        converters.add(new PropertiesPersonHttpMessageConverter());
        for ( HttpMessageConverter<?>    converter  : converters) {
            System.err.println("=================="+converter);
        }
    }

}
