package com.ming.venue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ming.venue.entity.AddressSearchHistory;
import com.ming.venue.entity.Member;

public interface AddressSearchHistoryRepository extends JpaRepository<AddressSearchHistory, Integer> {
	List<AddressSearchHistory> findByQueryStringEquals(String queryString);
	List<AddressSearchHistory> findByMemberOrderByRegisterDatetimeDesc(Member member);
}
