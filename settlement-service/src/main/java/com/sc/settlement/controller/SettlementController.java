package com.sc.settlement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sc.settlement.api.common.GenericResponse;
import com.sc.settlement.api.common.ResponseStatus;
import com.sc.settlement.api.settlement.SettlementAPI;
import com.sc.settlement.api.settlement.SettlementDTO;
import com.sc.settlement.api.settlement.TradeRequest;
import com.sc.settlement.service.SettlementService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SettlementController implements SettlementAPI {

	private final SettlementService settlementService;
	
	@Override
	public ResponseEntity<?> getSettlement(String tradeId) {
		SettlementDTO settlementDTO = settlementService.getByTradeId(tradeId);
		return ResponseEntity.ok(settlementDTO);
	}

	@Override
	public ResponseEntity<?> createSettlement(TradeRequest tradeRequest) {
		boolean isSuccessful = true;
		try {
			settlementService.create(tradeRequest);
		} catch(Exception e) {
			isSuccessful = false;
			log.error("Error to create settlement", e);
		}
		
		return isSuccessful ? 
				ResponseEntity.ok(GenericResponse.builder()
						.status(ResponseStatus.SUCCESS.value())
						.message("Created a settlement successfully")
						.build()) :
					ResponseEntity.ok(GenericResponse.builder()
							.status(ResponseStatus.ERROR.value())
							.message("Error to a settlement!!!")
							.build());
		
	}


}
