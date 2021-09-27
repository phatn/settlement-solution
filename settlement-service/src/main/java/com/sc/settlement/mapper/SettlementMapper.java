package com.sc.settlement.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sc.settlement.api.settlement.PartyAccountDTO;
import com.sc.settlement.api.settlement.SettlementDTO;
import com.sc.settlement.api.settlement.TradeRequest;
import com.sc.settlement.domain.PartyAccount;
import com.sc.settlement.domain.Settlement;
import com.sc.settlement.service.CurrencyService;
import com.sc.settlement.service.SSIReferenceService;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class SettlementMapper {
	
	@Autowired
	@Qualifier("ssiReferenceService")
	protected  SSIReferenceService ssiReferenceService;
	
	@Autowired
	@Qualifier("currencyService")
	protected  CurrencyService currencyService;
	
	@Autowired
	protected CurrencyMapper currencyMapper;
	
	@Mapping(source = "settlement.ssiReference.receiverParty", target = "receiverParty")
	@Mapping(source = "settlement.ssiReference.payerParty", target = "payerParty")
	@Mapping(source = "settlement.ssiReference.supportingInformation", target = "supportingInformation")
	@Mapping(source = "settlement.currency.code", target = "currency")
	public abstract SettlementDTO toSettlementDTO(Settlement settlement);
	
	public abstract PartyAccountDTO toPartyAccountDTO(PartyAccount partyAccount);
	
	@Mapping(target = "ssiReference", expression = "java(ssiReferenceService.getBySSICode(tradeRequest.getSsiCode()))")
	@Mapping(target = "currency", expression = "java(currencyMapper.toCurrency(currencyService.getByCode(tradeRequest.getCurrency())))")
	@Mapping(target = "messageId", expression = "java(java.util.UUID.randomUUID().toString())")
	@Mapping(target = "id", ignore = true)
	public abstract Settlement toSettlement(TradeRequest tradeRequest);
	

}
