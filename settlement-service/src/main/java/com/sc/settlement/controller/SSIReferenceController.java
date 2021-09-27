package com.sc.settlement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sc.settlement.api.settlement.SSIReferenceAPI;
import com.sc.settlement.api.settlement.SSIReferenceDTO;
import com.sc.settlement.service.SSIReferenceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SSIReferenceController implements SSIReferenceAPI {

	private final SSIReferenceService ssiReferenceService;
	
	@Override
	public ResponseEntity<List<SSIReferenceDTO>> getAll() {
		return ResponseEntity.ok(ssiReferenceService.getAll());
	}

}
