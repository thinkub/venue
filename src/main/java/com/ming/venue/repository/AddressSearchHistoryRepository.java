package com.ming.venue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ming.venue.entity.AddressSearchHistory;

public interface AddressSearchHistoryRepository extends JpaRepository<AddressSearchHistory, Integer> {
}
