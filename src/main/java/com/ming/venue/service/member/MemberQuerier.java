package com.ming.venue.service.member;

import com.ming.venue.entity.Member;

public interface MemberQuerier {
	Member findByMemberId(String memberId);
}
