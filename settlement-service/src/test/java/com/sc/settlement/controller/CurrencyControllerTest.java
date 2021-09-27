package com.sc.settlement.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.sc.settlement.api.settlement.CurrencyDTO;
import com.sc.settlement.service.CurrencyService;


@WebMvcTest(CurrencyController.class)
public class CurrencyControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CurrencyService currencyService;
	
	@Test
	void shouldReturnAllCurrencies() throws Exception {
		
		List<CurrencyDTO> currencyDTOs = new ArrayList<>();
		currencyDTOs.add(CurrencyDTO.builder().id(1L).name("Dollars").code("USD").build());
		currencyDTOs.add(CurrencyDTO.builder().id(2L).name("Euro").code("EUR").build());
		currencyDTOs.add(CurrencyDTO.builder().id(3L).name("Dong").code("VND").build());
		
		when(currencyService.getAll()).thenReturn(currencyDTOs);
		
		mockMvc.perform(get("/api/currency")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].id", is(currencyDTOs.get(0).getId().intValue())))
				.andExpect(jsonPath("$[0].name", is(currencyDTOs.get(0).getName())))
				.andExpect(jsonPath("$[0].code", is(currencyDTOs.get(0).getCode())))
				.andExpect(jsonPath("$[1].id", is(currencyDTOs.get(1).getId().intValue())))
				.andExpect(jsonPath("$[1].name", is(currencyDTOs.get(1).getName())))
				.andExpect(jsonPath("$[1].code", is(currencyDTOs.get(1).getCode())))
				.andExpect(jsonPath("$[2].id", is(currencyDTOs.get(2).getId().intValue())))
				.andExpect(jsonPath("$[2].name", is(currencyDTOs.get(2).getName())))
				.andExpect(jsonPath("$[2].code", is(currencyDTOs.get(2).getCode())));
	}
}
