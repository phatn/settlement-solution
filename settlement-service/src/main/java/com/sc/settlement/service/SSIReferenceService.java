package com.sc.settlement.service;

import java.util.List;

import com.sc.settlement.api.settlement.SSIReferenceDTO;
import com.sc.settlement.domain.SSIReference;

public interface SSIReferenceService {
	
	SSIReference getBySSICode(String ssiCode);
	
	List<SSIReferenceDTO> getAll();

}
