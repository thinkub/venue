package com.ming.venue.model.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@NoArgsConstructor
public class Meta {
	@JsonProperty(value = "is_end")
	private boolean end;
	@JsonProperty(value = "pageable_count")
	private int pageableCount;
	@JsonProperty(value = "total_count")
	private int totalCount;
}
