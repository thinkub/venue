package com.ming.venue.model.address;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.ming.venue.entity.Member;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressDetailResponse {
	private String address;
	private String roadAddress;
	private String daumAddressUrl;

	public static AddressDetailResponse from(Document document, String daumAddressUrl) {
		Document.Address address = Optional.ofNullable(document.getAddress()).orElseGet(Document.Address::new);
		Document.RoadAddress roadAddress = Optional.ofNullable(document.getRoadAddress()).orElseGet(Document.RoadAddress::new);

		return new AddressDetailResponse(address.getAddressName(),
										 roadAddress.getAddressName(),
										 createDaumAddress(daumAddressUrl, document.getY(), document.getX()));
	}

	private static String createDaumAddress(String daumAddressUri, String latitude, String longitude) {
		return daumAddressUri + latitude + "," + longitude;
	}

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@Getter
	public static class Search {
		private String query;
		private Pageable pageable;
		private int memberNo;

		public static Search from(String query, Pageable pageable, Member member) {
			return new Search(query, pageable, member.getMemberNo());
		}
	}
}
