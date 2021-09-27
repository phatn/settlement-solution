package com.sc.settlement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sc.settlement.api.exception.NotFoundException;
import com.sc.settlement.api.settlement.CurrencyDTO;
import com.sc.settlement.domain.Currency;
import com.sc.settlement.mapper.CurrencyMapper;
import com.sc.settlement.repository.CurrencyRepository;

import lombok.RequiredArgsConstructor;

@Service("currencyService")
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

	private final CurrencyRepository currencyRepository;
	
	private final CurrencyMapper currencyMapper;
	
	@Override
	public List<CurrencyDTO> getAll() {
		return currencyMapper.toCurrencyDTOs(currencyRepository.findAllByOrderByCodeAsc());
	}

	@Override
	public CurrencyDTO getByCode(String code) {
		Currency currency = currencyRepository.findByCode(code)
				.orElseThrow(() -> new NotFoundException("No currency found for code: " + code));
		return currencyMapper.toCurrencyDTO(currency);
	}

}
