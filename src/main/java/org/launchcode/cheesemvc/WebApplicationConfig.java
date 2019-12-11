package org.launchcode.cheesemvc;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

public class WebApplicationConfig implements WebMvcConfigurer {
    // Create managed bean to allow autowiring
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor( authenticationInterceptor() );
        registry.addInterceptor( new MappedInterceptor(new String[]{"/**"}, authenticationInterceptor()) );

    }
}
