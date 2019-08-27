package com.ming.venue.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "address_search_history")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class AddressSearchHistory {
	@Id
	@Column(name = "address_search_history_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressSearchHistoryId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	private Member member;
	@Column(name = "query_string")
	private String queryString;
	@Column(name = "register_datetime")
	private LocalDateTime registerDatetime;
}
