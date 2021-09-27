package com.sc.settlement.api.settlement;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiParam;

@RequestMapping("/api")
public interface SettlementAPI {
	
	@GetMapping(
            value = "/settlement/{tradeId}",
            produces = "application/json"
    )
	ResponseEntity<?> getSettlement(@ApiParam(example = "16846548") @PathVariable String tradeId);

	@PostMapping(
		    value    = "/settlement",
		    consumes = "application/json",
		    produces = "application/json")
	ResponseEntity<?> createSettlement(@Valid @RequestBody TradeRequest tradeRequest);
}
