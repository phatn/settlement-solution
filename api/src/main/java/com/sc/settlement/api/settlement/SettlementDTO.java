package com.sc.settlement.api.settlement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SettlementDTO {
	
	private String tradeId;
	
	private String messageId;
	
	private Double amount;
	
	private String valueDate;
	
	private String currency;
	
	private PartyAccountDTO payerParty;
	
	private PartyAccountDTO receiverParty;
	
	private String supportingInformation;
	
}
