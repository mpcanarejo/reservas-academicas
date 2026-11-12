package com.grupo2.reservas.config;

import com.grupo2.reservas.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // Creamos el interceptor
        LoggingInterceptor interceptor = new LoggingInterceptor();
        registry.addInterceptor(interceptor)
                .addPathPatterns("/api/**");
    }
}
