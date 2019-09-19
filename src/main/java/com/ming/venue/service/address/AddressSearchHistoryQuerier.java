package com.ming.venue.service.address;

import java.util.List;

import com.ming.venue.entity.AddressSearchHistory;
import com.ming.venue.entity.Member;

public interface AddressSearchHistoryQuerier {
	List<AddressSearchHistory> findByQueryString(String queryString);
	List<AddressSearchHistory> findSortByMember(Member member);
}
