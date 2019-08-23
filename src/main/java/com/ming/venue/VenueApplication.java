package com.ming.venue;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ming.venue.configuration.JasyptConfig;
import com.ming.venue.entity.Member;
import com.ming.venue.repository.MemberRepository;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = {VenueApplication.BASE_PACKAGE})
@EnableJpaRepositories(value = VenueApplication.BASE_PACKAGE)
@EntityScan(
		basePackageClasses = {Jsr310JpaConverters.class},
		basePackages = VenueApplication.BASE_PACKAGE + ".entity")
@EnableFeignClients
public class VenueApplication {
	public static final String BASE_PACKAGE = "com.ming.venue";

	@Autowired
	private JasyptConfig jasyptConfig;


	public static void main(String[] args) {
		SpringApplication.run(VenueApplication.class, args);
	}

	@Bean
	public CommandLineRunner initMember(MemberRepository memberRepository) {
//		StringEncryptor stringEncryptor = jasyptConfig.stringEncryptor();
//		String encryptPassword = stringEncryptor.encrypt("thinkub1!");

		return (args) ->
			memberRepository.save(Member.init("thinkub", "thinkub1!"));
	}
}
