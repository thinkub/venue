package com.ming.venue.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class KakaoFeignConfiguration {
	@Bean
	public RequestInterceptor kakaoRequestInterceptor() {
		return new KakaoRequestInterceptor();
	}

	public class KakaoRequestInterceptor implements RequestInterceptor {
		@Value("${kakao.appKey}")
		private String appKey;

		@Override
		public void apply(RequestTemplate requestTemplate) {
			requestTemplate.header("Authorization", appKey);
		}
	}
}
