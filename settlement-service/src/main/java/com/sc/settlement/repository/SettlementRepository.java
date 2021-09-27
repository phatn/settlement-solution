package com.sc.settlement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sc.settlement.domain.Settlement;

public interface SettlementRepository extends JpaRepository<Settlement, Long> {
	
@Query(
		"SELECT DISTINCT s " +
		"FROM " +
			"Settlement s JOIN FETCH s.ssiReference sr " +
			"JOIN FETCH sr.payerParty " +
			"JOIN FETCH sr.receiverParty " +
			"JOIN FETCH s.currency " +
		"WHERE s.tradeId = :tradeId"
	)
	Optional<Settlement> findByTradeId(@Param("tradeId") Long tradeId);
	

}
