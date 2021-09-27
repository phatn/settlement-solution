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

import com.sc.settlement.api.settlement.SSIReferenceDTO;
import com.sc.settlement.service.SSIReferenceService;

@WebMvcTest(SSIReferenceController.class)
public class SSIReferenceControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SSIReferenceService ssiReferenceService;
	
	@Test
	void shouldReturnAllSSIReferences() throws Exception {
		
		List<SSIReferenceDTO> ssiReferenceDTOs = new ArrayList<>();
		ssiReferenceDTOs.add(SSIReferenceDTO.builder().SSICode("DBS_OCBC_1").build());
		ssiReferenceDTOs.add(SSIReferenceDTO.builder().SSICode("OCBC_DBS_1").build());
		ssiReferenceDTOs.add(SSIReferenceDTO.builder().SSICode("OCBC_DBS_2").build());
		ssiReferenceDTOs.add(SSIReferenceDTO.builder().SSICode("DBS_SCB").build());
		ssiReferenceDTOs.add(SSIReferenceDTO.builder().SSICode("CITI_GS").build());
		
		when(ssiReferenceService.getAll()).thenReturn(ssiReferenceDTOs);
		
		mockMvc.perform(get("/api/ssiReference")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(5)))
				.andExpect(jsonPath("$[0].ssicode", is(ssiReferenceDTOs.get(0).getSSICode())))
				.andExpect(jsonPath("$[1].ssicode", is(ssiReferenceDTOs.get(1).getSSICode())))
				.andExpect(jsonPath("$[2].ssicode", is(ssiReferenceDTOs.get(2).getSSICode())))
				.andExpect(jsonPath("$[3].ssicode", is(ssiReferenceDTOs.get(3).getSSICode())))
				.andExpect(jsonPath("$[4].ssicode", is(ssiReferenceDTOs.get(4).getSSICode())));
	}
}
