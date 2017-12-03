package com.tuneride.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication//(scanBasePackages = {"com.tuneride.server.repository", "com.tuneride.server.service.impl", "com.tuneride.server.web.controller"})
//@EntityScan("com.tuneride.server.domain")
@EnableAutoConfiguration /*(exclude = {
       // DataSourceAutoConfiguration.class,
		SecurityAutoConfiguration.class,
        MetricFilterAutoConfiguration.class,
        MetricRepositoryAutoConfiguration.class
})*/
//@EnableScheduling
//@EnableAsync
@Configuration
public class TunerideApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TunerideApplication.class, args);
	}
	
	 /**
     * Cross origin request configuration
     * */
    @Bean
    public WebMvcConfigurerAdapter corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedHeaders("accept","authorization","content-type","x-requested-with")
                							.allowedOrigins("*")
                							.allowCredentials(true)
                							.allowedMethods("*");
            }
        };
    }
    
    /**
	 * Encrypt passwords to store in database
	 * */
	/*@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

}
