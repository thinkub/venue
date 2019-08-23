package com.ming.venue.model;

import org.springframework.data.domain.PageRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.ming.venue.model.exception.PagingInfoException;

/**
 * @Author by Carrey on 2019-01-16
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PagingInfo {

	private transient static final int DEFAULT_SIZE = 20;
	private int pageNo;
	private int pagePerSize;

	public static PagingInfo of(int pageNo, int pagePerSize) {
		return new PagingInfo(pageNo, pagePerSize);
	}

	public static PagingInfo of(int pageNo) {
		return new PagingInfo(pageNo, DEFAULT_SIZE);
	}

	public PageRequest getPageRequest() {
		if (this.pageNo < 1) {
			throw new PagingInfoException("field[page] cannot be less than 1");
		}
		if (this.pagePerSize < 1) {
			throw new PagingInfoException("field[size] cannot be less than 1");
		}
		return PageRequest.of(pageNo - 1, pagePerSize);
	}
}
