package com.ming.venue.service.address;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

import com.ming.venue.entity.AddressSearchHistory;
import com.ming.venue.entity.Member;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class AddressSearchHistoryQuerierTest {
	private static final Integer MEMBER_NO = 1;
	private static final String QUERY_STRING1 = "삼평동";
	private static final String QUERY_STRING2 = "삼성동";
	private static final String QUERY_STRING3 = "인계동";

	@Autowired
	private AddressSearchHistoryCommander addressSearchHistoryCommander;
	@Autowired
	private AddressSearchHistoryQuerier addressSearchHistoryQuerier;

	@Test
	public void 회원별_검색히스토리_최신순Test() {
		// given
		addressSearchHistoryCommander.saveAddressSearch(MEMBER_NO, QUERY_STRING1);
		addressSearchHistoryCommander.saveAddressSearch(MEMBER_NO, QUERY_STRING2);
		addressSearchHistoryCommander.saveAddressSearch(MEMBER_NO, QUERY_STRING3);

		// when
		List<AddressSearchHistory> result = addressSearchHistoryQuerier.findSortByMember(Member.builder().memberNo(MEMBER_NO).build());
		log.info("result: {}", result);

		// then
		assertThat(result.get(0).getQueryString(), is(QUERY_STRING3));
	}

}