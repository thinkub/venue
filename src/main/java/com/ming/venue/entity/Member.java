package com.ming.venue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

@Entity
@Table(name = "member")
@AllArgsConstructor(staticName = "of")
public class Member {
	@Id
	@Column(name = "member_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberNo;

	@Column(name = "member_id")
	private String memberId;

	@Column(name = "password")
	private String password;

	public static Member init(String memberId, String password) {
		return new Member(memberId, password);
	}

	private Member(String memberId, String password) {
		this.memberId = memberId;
		this.password = password;
	}
}
