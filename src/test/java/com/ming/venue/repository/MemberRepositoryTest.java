package com.ming.venue.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

import com.ming.venue.entity.Member;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class MemberRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void selectTest() {
		String memberId = "thinkub";
		Member member = memberRepository.findMemberByMemberIdEquals(memberId);
		log.info("member: {}", member);
		assertThat(memberId, is(member.getMemberId()));
	}
}