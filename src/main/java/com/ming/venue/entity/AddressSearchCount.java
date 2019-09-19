package com.ming.venue.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "address_search_count", indexes = @Index(columnList = "query_string", unique = true))
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class AddressSearchCount {
	@Id
	@Column(name = "address_search_count_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressSearchCountId;
	@Column(name = "query_string")
	private String queryString;
	@Column(name = "search_count")
	private long searchCount;
	@Column(name = "register_datetime")
	private LocalDateTime registerDatetime;
	@Column(name = "modify_datetime")
	private LocalDateTime modifyDatetime;

	public void addSearchCount() {
		this.searchCount++;
		this.modifyDatetime = LocalDateTime.now();
	}
}
