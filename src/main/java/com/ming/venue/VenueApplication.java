package com.ming.venue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ming.venue.entity.Member;
import com.ming.venue.repository.MemberRepository;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = {VenueApplication.BASE_PACKAGE})
@EnableJpaRepositories(value = VenueApplication.BASE_PACKAGE + ".repository")
@EntityScan(
		basePackageClasses = {Jsr310JpaConverters.class},
		basePackages = VenueApplication.BASE_PACKAGE + ".entity")
@EnableFeignClients
public class VenueApplication {
	public static final String BASE_PACKAGE = "com.ming.venue";

	public static void main(String[] args) {
		SpringApplication.run(VenueApplication.class, args);
	}

	@Bean
	public CommandLineRunner initMember(MemberRepository memberRepository) {
		Member member = Member.init("thinkub", "thinkub1!");
		member.executePasswordEncrypt();
		return (args) ->
			memberRepository.save(member);
	}
}
