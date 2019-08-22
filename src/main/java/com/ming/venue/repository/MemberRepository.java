package com.ming.venue.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ming.venue.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
