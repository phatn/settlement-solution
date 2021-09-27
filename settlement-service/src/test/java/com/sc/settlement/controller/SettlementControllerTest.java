package com.sc.settlement.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.sc.settlement.api.exception.NotFoundException;
import com.sc.settlement.api.settlement.PartyAccountDTO;
import com.sc.settlement.api.settlement.SettlementDTO;
import com.sc.settlement.api.settlement.TradeRequest;
import com.sc.settlement.service.SettlementService;
import com.sc.settlement.util.TestUtils;

@WebMvcTest(SettlementController.class)
public class SettlementControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SettlementService settlementService;
	
	@Test
	void shouldReturnSettlement() throws Exception {
		String tradeId = "16846548";
		
		PartyAccountDTO payerParty = PartyAccountDTO.builder().accountNumber("438421").accountBank("OCBCSGSGXXX").build();
		PartyAccountDTO receiverParty = PartyAccountDTO.builder().accountNumber("05461368").accountBank("DBSSGB2LXXX").build();
		
		SettlementDTO settlementDTO = SettlementDTO.builder()
				.tradeId(tradeId)
				.messageId("e8a57dc0-2119-49a4-85fe-5e94415b2cad")
				.amount(12894.65)
				.valueDate("20022020")
				.payerParty(payerParty)
				.receiverParty(receiverParty)
				.supportingInformation("/BNF/FFC-4697132")
				.build();
		
		when(settlementService.getByTradeId(tradeId)).thenReturn(settlementDTO);
		
		mockMvc.perform(get("/api/settlement/" + tradeId)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.tradeId", is(settlementDTO.getTradeId())))
				.andExpect(jsonPath("$.messageId", is(settlementDTO.getMessageId())))
				.andExpect(jsonPath("$.amount", is(settlementDTO.getAmount())))
				.andExpect(jsonPath("$.valueDate", is(settlementDTO.getValueDate())))
				.andExpect(jsonPath("$.payerParty.accountNumber", is(payerParty.getAccountNumber())))
				.andExpect(jsonPath("$.payerParty.accountBank", is(payerParty.getAccountBank())))
				.andExpect(jsonPath("$.receiverParty.accountNumber", is(receiverParty.getAccountNumber())))
				.andExpect(jsonPath("$.receiverParty.accountBank", is(receiverParty.getAccountBank())))
				.andExpect(jsonPath("$.supportingInformation", is(settlementDTO.getSupportingInformation())));
	}
	
	
	@Test
	void shouldReturnNotFoundSettlement() throws Exception {
		String tradeId = "16846549";
		String errorMessage = "No settlement found for tradeId: " + tradeId;
		String path = "/api/settlement/" + tradeId;
		
		when(settlementService.getByTradeId(tradeId)).thenThrow(new NotFoundException(errorMessage));
		
		mockMvc.perform(get("/api/settlement/" + tradeId)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status", is("error")))
				.andExpect(jsonPath("$.path", is(path)))
				.andExpect(jsonPath("$.httpStatus", is("NOT_FOUND")))
				.andExpect(jsonPath("$.errorMessage", is(errorMessage)));
				
	}
	
	@Test
	void shouldCreateSettlement() throws Exception {
		String tradeId = "16846549";
		TradeRequest tradeRequest = TradeRequest.builder()
				.tradeId(tradeId)
				.amount(3000D)
				.currency("USD")
				.ssiCode("OCBC_DBS_2")
				.valueDate("17092021")
				.build();
		
		doNothing().when(settlementService).create(tradeRequest);
		
		mockMvc.perform(post("/api/settlement")
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestUtils.stringify(tradeRequest)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status", is("success")))
				.andExpect(jsonPath("$.message", is("Created a settlement successfully")));
				
	}	
}
