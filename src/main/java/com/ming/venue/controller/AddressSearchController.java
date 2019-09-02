package com.ming.venue.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ming.venue.entity.Member;
import com.ming.venue.model.address.AddressDetailResponse;
import com.ming.venue.service.address.AddressQuerier;

@RestController
public class AddressSearchController {
	@Autowired
	@Qualifier("addressSearchService")
	private AddressQuerier addressQuerier;


	@GetMapping(value = "/api/v1/address/")
	public Page<AddressDetailResponse> getAddress(@RequestParam("query") String query, @PageableDefault Pageable page,
												  @RequestParam("member")Member member) {
		return addressQuerier.findAddressByQuery(AddressDetailResponse.Search.from(query, page, member));
	}


	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Page handelException(Exception e) {
		return Page.empty();
	}
}
