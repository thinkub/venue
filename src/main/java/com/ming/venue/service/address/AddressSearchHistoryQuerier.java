package com.ming.venue.service.address;

import java.util.List;

import com.ming.venue.entity.AddressSearchHistory;
import com.ming.venue.entity.Member;
import com.ming.venue.repository.AddressSearchHistoryRepository;

public interface AddressSearchHistoryQuerier {
	List<AddressSearchHistory> findByQueryString(String queryString);
	List<AddressSearchHistory> findByMember(Member member);
}
