package com.tuneride.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.tuneride.server.service.impl","com.tuneride.server.web.controller"})
@EntityScan("com.tuneride.server.domain")
@EnableAutoConfiguration(exclude = {
       // DataSourceAutoConfiguration.class,
		SecurityAutoConfiguration.class,
        MetricFilterAutoConfiguration.class,
        MetricRepositoryAutoConfiguration.class
})
//@EnableScheduling
//@EnableAsync

public class TunerideApplication {

	public static void main(String[] args) {
		SpringApplication.run(TunerideApplication.class, args);
	}
}
