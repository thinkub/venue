package com.ming.venue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = {VenueApplication.BASE_PACKAGE},
					   exclude = {DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableJpaRepositories(value = VenueApplication.BASE_PACKAGE)
public class VenueApplication {
	public static final String BASE_PACKAGE = "com.ming.venue";

	public static void main(String[] args) {
		SpringApplication.run(VenueApplication.class, args);
	}
}
