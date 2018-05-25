package com.bdqnsxt.oa.conf;


import com.bdqnsxt.oa.OaApplication;
import com.bdqnsxt.oa.component.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//静态路径优化
//maven优化
@Configuration
@ComponentScan(basePackageClasses = OaApplication.class, useDefaultFilters = true)
public class SessionConfig extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则, 这里假设拦截 /url 后面的全部链接
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(new String[]{"/css/**", "/ext/**", "/images/**", "/core/**"});
        super.addInterceptors(registry);
    }

}
