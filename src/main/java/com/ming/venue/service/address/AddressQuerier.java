package com.ming.venue.service.address;

import org.springframework.data.domain.Page;

import com.ming.venue.model.address.AddressDetailResponse;

public interface AddressQuerier {
	Page<AddressDetailResponse> findAddressByQuery(AddressDetailResponse.Search search);
}
