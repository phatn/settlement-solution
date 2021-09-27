package com.sc.settlement.service;

import com.sc.settlement.api.settlement.SettlementDTO;
import com.sc.settlement.api.settlement.TradeRequest;

public interface SettlementService {
	
	SettlementDTO getByTradeId(String tradeId);
	
	void create(TradeRequest tradeRequest);
}
