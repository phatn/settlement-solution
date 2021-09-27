package com.sc.settlement.api.settlement;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeRequest {
	
	@Schema(example = "16846548")
	@NotBlank(message = "TradeId is required")
	private String tradeId;
	
	@Schema(example = "OCBC_DBS_2")
	@NotBlank(message = "SSICode is required")
	private String ssiCode;
	
	@Schema(example = "1000")
	@NotNull(message = "Amount is required")
	private Double amount;
	
	@Schema(example = "USD")
	@NotBlank(message = "Currency is required")
	@Size(min = 3, max = 3, message = "Length of currency must be 3")
	@Pattern(regexp = "^\\w+$", message = "Currency is invalid")
	private String currency;
	
	
	@Schema(example = "2021-09-27")
	@NotBlank(message = "ValueDate is required")
	private String valueDate;
}
