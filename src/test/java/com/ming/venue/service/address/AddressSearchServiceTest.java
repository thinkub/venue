package com.ming.venue.service.address;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
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

import com.ming.venue.entity.AddressSearchHistory;
import com.ming.venue.entity.Member;
import com.ming.venue.model.address.AddressDetailResponse;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class AddressSearchServiceTest {
	@Autowired
	@Qualifier("addressSearchService")
	private AddressQuerier addressQuerier;
	@Autowired
	@Qualifier("addressSearchHistoryService")
	private AddressSearchHistoryQuerier addressSearchHistoryQuerier;

	private AddressDetailResponse.Search search;

	@Before
	public void init() {
		String query = "신월동";
		Pageable pageable = PageRequest.of(1, 10);
		Member member = Member.builder().memberNo(1).build();

		search = AddressDetailResponse.Search.from(query, pageable, member);
	}

	@Test
	public void findAddressByQuery() {
		// given

		// when
		Page<AddressDetailResponse> responses = addressQuerier.findAddressByQuery(search);
		log.info("response: {}", responses);

		// then
		assertThat(responses, is(notNullValue()));
	}

	@Test
	public void 조회이력저장aop_test() {
		// given
		Page<AddressDetailResponse> responses = addressQuerier.findAddressByQuery(search);
		log.info("response: {}", responses);

		// when
		List<AddressSearchHistory> addressSearchHistorys = addressSearchHistoryQuerier.findByQueryString(search.getQuery());
		log.info("response: {}", addressSearchHistorys);

		// then
		assertThat(addressSearchHistorys, is(notNullValue()));

	}
}