package com.sc.settlement.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.settlement.api.exception.InvalidInputException;
import com.sc.settlement.api.exception.NotFoundException;
import com.sc.settlement.api.settlement.SettlementDTO;
import com.sc.settlement.api.settlement.TradeRequest;
import com.sc.settlement.domain.Settlement;
import com.sc.settlement.mapper.SettlementMapper;
import com.sc.settlement.repository.SettlementRepository;

import lombok.RequiredArgsConstructor;

@Service("settlementService")
@RequiredArgsConstructor
public class SettlementServiceImpl implements SettlementService {

	private final SettlementRepository settlementRepository;
	
	private final SettlementMapper settlementMapper;
	
	@Transactional(readOnly = true)
	@Override
	public SettlementDTO getByTradeId(String tradeId) {
		Settlement settlement = settlementRepository.findByTradeId(convertToTradeId(tradeId))
				.orElseThrow(() -> new NotFoundException("No settlement found for tradeId: " + tradeId));
		return settlementMapper.toSettlementDTO(settlement);
	}
	
	

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void create(TradeRequest tradeRequest) {
		Settlement settlement = settlementMapper.toSettlement(tradeRequest);
		settlementRepository.save(settlement);
		
	}
	
	private Long convertToTradeId(String tradeId) {
		try {
			return Long.parseLong(tradeId);
		} catch(NumberFormatException e) {
			throw new InvalidInputException("TradeId (" + tradeId + ") is invalid!");
		}
	}
}
