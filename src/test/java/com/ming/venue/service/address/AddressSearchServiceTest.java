package com.ming.venue.service.address;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

import com.ming.venue.model.address.AddressDetailResponse;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class AddressSearchServiceTest {
	@Autowired
	@Qualifier("addressSearchService")
	private AddressQuerier addressQuerier;

	@Test
	public void findAddressByQuery() {
		// given
		String query = "신월동";
		Pageable pageable = PageRequest.of(1, 10);

		// when
		Page<AddressDetailResponse> responses = addressQuerier.findAddressByQuery(AddressDetailResponse.Search.from(query, pageable));
		log.info("response: {}", responses);

		// then
		assertThat(responses, is(notNullValue()));
	}
}