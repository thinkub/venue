package com.ming.venue.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "address_search_history", indexes = @Index(columnList = "member_id"))
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
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
