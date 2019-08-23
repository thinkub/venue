package com.ming.venue.model.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoAddressResponse {

	static class Meta {
		@JsonProperty(value = "is_end")
		private boolean end;
		@JsonProperty(value = "pageable_count")
		private int pageableCount;
		@JsonProperty(value = "total_count")
		private int totalCount;
	}
}
