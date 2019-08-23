package com.ming.venue.model;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Author by Carrey on 2019-01-16
 * Pageable을 사용하는 API에 대한 Generic Response 클래스
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageableResponse<T> {

	private enum Result {
		SUCCESS, FAIL
	}

	private Result result;
	private String message;
	private Body<T> body;

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Getter
	public static class Body<T> {

		private static final List EMPTY_LIST = Collections.EMPTY_LIST;
		private List<T> list;
		private long totalDataCount;
		private int responseCount;
		private int totalPageCount;
		private int currentPageCount;
		private int pageSize;

		public static Body empty() {
			return new Body(EMPTY_LIST, 0, 0, 0, 0, 0);
		}
	}

	public static <P, T> PageableResponse<T> success(Page<P> page, Function<P, T> function) {

		List<T> list = page.getContent().stream()
						   .map((P p) -> function.apply(p))
						   .collect(Collectors.toList());

		long totalDataCount = page.getTotalElements();
		int pageSize = page.getSize();
		int totalPageCount = page.getTotalPages();
		int currentPageCount = page.getNumber() + 1;

		Body<T> body = new Body<>(list, totalDataCount, list.size(), totalPageCount, currentPageCount, pageSize);
		return new PageableResponse<>(Result.SUCCESS, "", body);
	}

	public static PageableResponse fail(String message) {
		return new PageableResponse(Result.FAIL, message, Body.empty());
	}

	@JsonIgnore
	public boolean isSuccess() {
		return this.result == Result.SUCCESS;
	}

	@JsonIgnore
	public boolean isFail() {
		return this.result == Result.FAIL;
	}
}
