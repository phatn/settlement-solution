package com.sc.settlement.service;

import java.util.List;

import com.sc.settlement.api.settlement.CurrencyDTO;

public interface CurrencyService {
	
	List<CurrencyDTO> getAll();
	
	CurrencyDTO getByCode(String code);

}
