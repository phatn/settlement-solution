package com.sc.settlement.api.settlement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyDTO {
	
	private Long id;
	
	private String name;
	
	private String code;
	
	private String symbol;

}
