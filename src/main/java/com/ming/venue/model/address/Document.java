package com.ming.venue.model.address;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ming.venue.util.BooleanYnDeserializer;
import com.ming.venue.util.BooleanYnSerializer;

@NoArgsConstructor
public class Document {
	@JsonProperty(value = "address_name")
	private String addressName;
	@JsonProperty(value = "address_type")
	private AddressType addressType;
	@JsonProperty(value = "x")
	private String x;
	@JsonProperty(value = "y")
	private String y;
	@JsonProperty(value = "address")
	private Address address;
	@JsonProperty(value = "road_address")
	private RoadAddress roadAddress;

	@NoArgsConstructor
	static class Address {
		@JsonProperty(value = "address_name")
		private String addressName;
		@JsonProperty(value = "region_1depth_name")
		private String regionOneDepthName;
		@JsonProperty(value = "region_2depth_name")
		private String regionTwoDepthName;
		@JsonProperty(value = "region_3depth_name")
		private String regionThreeDepthName;
		@JsonProperty(value = "region_3depth_h_name")
		private String regionThreeDepthHName;
		@JsonProperty(value = "h_code")
		private String hCode;
		@JsonProperty(value = "b_code")
		private String bCode;
		@JsonProperty(value = "mountain_yn")
		@JsonSerialize(using = BooleanYnSerializer.class)
		@JsonDeserialize(using = BooleanYnDeserializer.class)
		private boolean mountain;
		@JsonProperty(value = "main_address_no")
		private String mainAddressNo;
		@JsonProperty(value = "sub_address_no")
		private String subAddressNo;
		@JsonProperty(value = "zip_code")
		private String zipCode;
		@JsonProperty(value = "x")
		private String x;
		@JsonProperty(value = "y")
		private String y;
	}

	@NoArgsConstructor
	static class RoadAddress {
		@JsonProperty(value = "address_name")
		private String addressName;
		@JsonProperty(value = "region_1depth_name")
		private String regionOneDepthName;
		@JsonProperty(value = "region_2depth_name")
		private String regionTwoDepthName;
		@JsonProperty(value = "region_3depth_name")
		private String regionThreeDepthName;
		@JsonProperty(value = "road_name")
		private String roadName;
		@JsonProperty(value = "underground_yn")
		@JsonSerialize(using = BooleanYnSerializer.class)
		@JsonDeserialize(using = BooleanYnDeserializer.class)
		private boolean underground;
		@JsonProperty(value = "main_building_no")
		private String mainBuildingNo;
		@JsonProperty(value = "sub_building_no")
		private String subBuildingNo;
		@JsonProperty(value = "building_name")
		private String buildingName;
		@JsonProperty(value = "zone_no")
		private String zoneNo;
		@JsonProperty(value = "x")
		private String x;
		@JsonProperty(value = "y")
		private String y;
	}

	@Getter
	@AllArgsConstructor
	public enum AddressType {
		REGION, ROAD, REGION_ADDR, ROAD_ADDR;

	}
}
