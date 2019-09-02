package com.ming.venue.service.address;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ming.venue.entity.AddressSearchCount;
import com.ming.venue.entity.AddressSearchHistory;
import com.ming.venue.entity.Member;
import com.ming.venue.repository.AddressSearchCountRepository;
import com.ming.venue.repository.AddressSearchHistoryRepository;

@Service
public class AddressSearchHistoryService implements AddressSearchHistoryCommander, AddressSearchHistoryQuerier {
	@Autowired
	private AddressSearchHistoryRepository addressSearchHistoryRepository;
	@Autowired
	private AddressSearchCountRepository addressSearchCountRepository;

	@Transactional
	public void saveAddressSearch(Integer memberNo, String queryString) {
		AddressSearchHistory addressSearchHistory = AddressSearchHistory.builder()
																		.member(Member.builder().memberNo(memberNo).build())
																		.queryString(queryString)
																		.registerDatetime(LocalDateTime.now())
																		.build();
		addressSearchHistoryRepository.save(addressSearchHistory);
		addressSearchCountRepository.save(makeAddressSearchCount(queryString));
	}



	private AddressSearchCount makeAddressSearchCount(String queryString) {
		AddressSearchCount addressSearchCount = addressSearchCountRepository.findByQueryStringEquals(queryString);

		if (addressSearchCount != null) {
			addressSearchCount.addSearchCount();
			return addressSearchCount;
		}

		return AddressSearchCount.builder()
								 .searchCount(1)
								 .queryString(queryString)
								 .registerDatetime(LocalDateTime.now())
								 .modifyDatetime(LocalDateTime.now())
								 .build();
	}

	@Override
	public List<AddressSearchHistory> findByQueryString(String queryString) {
		return addressSearchHistoryRepository.findByQueryStringEquals(queryString);
	}

	@Override
	public List<AddressSearchHistory> findByMember(Member member) {
		return addressSearchHistoryRepository.findByMember(member);
	}
}
