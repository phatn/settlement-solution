package com.sc.settlement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sc.settlement.api.settlement.CurrencyAPI;
import com.sc.settlement.api.settlement.CurrencyDTO;
import com.sc.settlement.service.CurrencyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CurrencyController implements CurrencyAPI {
	
	
	private final CurrencyService currencyService;
	
	@Override
	public ResponseEntity<List<CurrencyDTO>> getAll() {
		return ResponseEntity.ok(currencyService.getAll());
	}
	
}
