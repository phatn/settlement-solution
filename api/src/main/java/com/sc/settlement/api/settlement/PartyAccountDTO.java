package com.sc.settlement.api.settlement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartyAccountDTO {
	
	private String accountNumber;
	
	private String accountBank;

}
