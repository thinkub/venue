package com.ming.venue.service.address;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ming.venue.client.KakaoAddressSearchClient;
import com.ming.venue.model.address.AddressDetailResponse;
import com.ming.venue.model.address.KakaoAddressResponse;

@Service
public class AddressSearchService implements AddressQuerier {
	@Value("${kakao.map.url}")
	private String mapUrl;

	@Autowired
	private KakaoAddressSearchClient kakaoAddressSearchClient;

	public Page<AddressDetailResponse> findAddressByQuery(AddressDetailResponse.Search search) {
		Pageable pageable = search.getPageable();
		KakaoAddressResponse kakaoAddressResponse =
				kakaoAddressSearchClient.getAddress(search.getQuery(), pageable.getPageNumber() + 1, pageable.getPageSize());

		if (kakaoAddressResponse == null) {
			return Page.empty();
		}
		List<AddressDetailResponse> responses = kakaoAddressResponse.getDocuments()
																	.stream()
																	.map(d -> AddressDetailResponse.from(d, mapUrl))
																	.collect(toList());
		return new PageImpl(responses, pageable, kakaoAddressResponse.getMeta().getTotalCount());
	}
}
