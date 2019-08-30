package com.ming.venue.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ming.venue.model.address.KakaoAddressResponse;


@FeignClient(name = "kakao-search", url = "${kakao.address.url}", configuration = KakaoFeignConfiguration.class)
public interface KakaoAddressSearchClient {
	@GetMapping(path = "/v2/local/search/address.json", produces = APPLICATION_JSON_UTF8_VALUE)
	KakaoAddressResponse getAddress(@RequestParam("query") String query, @RequestParam int page, @RequestParam int size);
}
