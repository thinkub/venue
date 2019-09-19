package com.ming.venue.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ming.venue.model.address.AddressDetailResponse;
import com.ming.venue.service.address.AddressSearchHistoryService;

@Aspect
@Component
public class AddressSearchHistoryAspect {
	@Autowired
	private AddressSearchHistoryService addressSearchHistoryService;


	@AfterReturning(pointcut = "execution(* com.ming.venue.service.address.AddressSearchService.findAddressByQuery(..))")
	public void addressSearchHistorySave(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		if (args.length == 0) {
			return;
		}
		if (!(args[0] instanceof AddressDetailResponse.Search)) {
			return;
		}
		AddressDetailResponse.Search search = (AddressDetailResponse.Search) args[0];
		addressSearchHistoryService.saveAddressSearch(search.getMemberNo(), search.getQuery());
	}
}
