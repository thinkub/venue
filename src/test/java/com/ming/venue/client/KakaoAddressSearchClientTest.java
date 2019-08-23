package com.ming.venue.client;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

import com.ming.venue.model.kakao.KakaoAddressResponse;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
@EnableFeignClients
public class KakaoAddressSearchClientTest {
	@Autowired
	private KakaoAddressSearchClient client;

	@Test
	public void getAddress() {
		String query = "전북 삼성동 100";
		KakaoAddressResponse response = client.getAddress(query);
		log.info("{}", response);
	}
}