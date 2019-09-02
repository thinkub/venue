package com.ming.venue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ming.venue.entity.AddressSearchCount;

public interface AddressSearchCountRepository extends JpaRepository<AddressSearchCount, Integer> {
	AddressSearchCount findByQueryStringEquals(String queryString);
}
