package com.sc.settlement.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.sc.settlement.api.settlement.CurrencyDTO;
import com.sc.settlement.domain.Currency;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CurrencyMapper {
	
	CurrencyDTO toCurrencyDTO(Currency currency);
	
	Currency toCurrency(CurrencyDTO currencyDTO);
	
	List<CurrencyDTO> toCurrencyDTOs(List<Currency> currencies);
}
