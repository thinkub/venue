package com.ming.venue.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ming.venue.configuration.KakaoFeignConfiguration;
import com.ming.venue.model.kakao.KakaoAddressResponse;

import feign.Param;

@FeignClient(name = "kakao-search", url = "${kakao.address.url}", configuration = KakaoFeignConfiguration.class)
public interface KakaoAddressSearchClient {
	@GetMapping(path = "/v2/local/search/address.{format}", produces = APPLICATION_JSON_UTF8_VALUE)
	KakaoAddressResponse getAddress(@Param(value = "query") String query);

}
