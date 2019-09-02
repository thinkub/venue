package com.ming.venue.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ming.venue.entity.AddressSearchHistory;
import com.ming.venue.entity.Member;
import com.ming.venue.model.address.AddressDetailResponse;
import com.ming.venue.service.address.AddressQuerier;
import com.ming.venue.service.address.AddressSearchHistoryQuerier;

@RestController(value = "/api/v1/address/")
public class AddressSearchController {
	@Autowired
	@Qualifier("addressSearchService")
	private AddressQuerier addressQuerier;
	@Autowired
	@Qualifier("addressSearchHistoryService")
	private AddressSearchHistoryQuerier addressSearchHistoryQuerier;

	public Page<AddressDetailResponse> getAddress(@RequestParam("query") String query, @PageableDefault Pageable page,
												  @RequestParam("member") Member member) {
		return addressQuerier.findAddressByQuery(AddressDetailResponse.Search.from(query, page, member));
	}

	@GetMapping(value = "/historys/{memberNo}")
	public List<AddressSearchHistory> getAddressSearchHistorys(@PathVariable("memberNo") int memberNo) {
		return addressSearchHistoryQuerier.findSortByMember(Member.builder().memberNo(memberNo).build());
	}


	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handelException(Exception e) {
		return e.getMessage();
	}
}
