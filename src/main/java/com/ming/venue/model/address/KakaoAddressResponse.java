package com.ming.venue.model.address;

import java.util.List;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class KakaoAddressResponse {
	private Meta meta;
	private List<Document> documents;
}
