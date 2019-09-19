package com.ming.venue.configuration;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import feign.codec.Encoder;

import feign.form.spring.SpringFormEncoder;

@Configuration
@EnableFeignClients
public class FeignClientConfig {
	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;

	@Bean
	@Primary
	public Encoder feignEncoder() {
		return new SpringFormEncoder(new SpringEncoder(messageConverters));
	}
}
