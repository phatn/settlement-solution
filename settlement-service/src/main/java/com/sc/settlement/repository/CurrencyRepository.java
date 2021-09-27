package com.sc.settlement.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sc.settlement.domain.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
	
	Optional<Currency> findByCode(String code);
	
	List<Currency> findAllByOrderByCodeAsc();
	
}
