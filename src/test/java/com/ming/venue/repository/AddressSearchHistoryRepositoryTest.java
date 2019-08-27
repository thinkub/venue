package com.ming.venue.repository;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
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
public class AddressSearchHistoryRepositoryTest {
	@Autowired
	private AddressSearchHistoryRepository addressSearchHistoryRepository;
	private static final Member member = Member.builder().memberNo(1).build();
	private static final AddressSearchHistory addressSearchHistory = AddressSearchHistory.builder()
																						 .member(member)
																						 .queryString("삼성동")
																						 .registerDatetime(LocalDateTime.now())
																						 .build();

	@Before
	public void init() {
		addressSearchHistoryRepository.save(addressSearchHistory);
	}


	@Test
	public void selectTest() {
		// given

		// when
		List<AddressSearchHistory> addressSearchHistories = addressSearchHistoryRepository.findAll();
		log.info("addressSearchHistory: {}", addressSearchHistories);

		// then
		assertThat(addressSearchHistories.size(), greaterThan(0));
	}

}