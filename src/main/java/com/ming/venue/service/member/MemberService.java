package com.ming.venue.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ming.venue.entity.Member;
import com.ming.venue.repository.MemberRepository;

@Service
public class MemberService implements MemberCommander, MemberQuerier {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void add(Member member) {
		member.executePasswordEncrypt();
		memberRepository.save(member);
	}

	@Override
	public void modify(Member member) {

	}

	@Override
	public Member findByMemberId(String memberId) {
		return memberRepository.findMemberByMemberIdEquals(memberId);
	}
}
