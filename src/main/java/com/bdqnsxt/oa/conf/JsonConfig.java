package com.bdqnsxt.oa.conf;

import com.bdqnsxt.oa.component.utils.MyDateFormat;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.DateFormat;

@Configuration
public class JsonConfig {

    @Bean
    public ObjectMapper getObjectMapper(){
        //SerializationFeature.FAIL_ON_EMPTY_BEANS ： 序列化时，忽略为空的字段
        //DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES： 反序列化时，忽略java类中不存在的字段
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /*
    @Bean
    public MappingJackson2HttpMessageConverter MappingJsonpHttpMessageConverter() {

        ObjectMapper mapper = getObjectMapper();

        // ObjectMapper为了保障线程安全性，里面的配置类都是一个不可变的对象
        // 所以这里的setDateFormat的内部原理其实是创建了一个新的配置类
        DateFormat dateFormat = mapper.getDateFormat();
        mapper.setDateFormat(new MyDateFormat(dateFormat));
        MappingJackson2HttpMessageConverter mappingJsonpHttpMessageConverter = new MappingJackson2HttpMessageConverter(
                mapper);
        return mappingJsonpHttpMessageConverter;
    }
    */
}
