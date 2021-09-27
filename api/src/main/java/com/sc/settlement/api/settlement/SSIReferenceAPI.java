package com.sc.settlement.api.settlement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface SSIReferenceAPI {
	
	@GetMapping(
            value = "/ssiReference",
            produces = "application/json"
    )
	ResponseEntity<List<SSIReferenceDTO>> getAll();

}
