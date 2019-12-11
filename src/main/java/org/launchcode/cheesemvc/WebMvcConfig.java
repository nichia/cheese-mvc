package org.launchcode.cheesemvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}

// If you are using Java version < 1.8 and Spring version < 5, use below code
// https://stackoverflow.com/questions/47552835/the-type-webmvcconfigureradapter-is-deprecated

//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
//}