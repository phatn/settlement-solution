package com.sc.settlement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.settlement.api.exception.NotFoundException;
import com.sc.settlement.api.settlement.SSIReferenceDTO;
import com.sc.settlement.domain.SSIReference;
import com.sc.settlement.mapper.SSIReferenceMapper;
import com.sc.settlement.repository.SSIReferenceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("ssiReferenceService")
public class SSIReferenceServiceImpl implements SSIReferenceService {

	private final SSIReferenceRepository ssiReferenceRepository;
	
	private final SSIReferenceMapper ssiReferenceMapper;
	
	@Transactional(readOnly = true)
	@Override
	public SSIReference getBySSICode(String ssiCode) {
		
		return ssiReferenceRepository.findBySSICode(ssiCode)
				.orElseThrow(() -> new NotFoundException("No SSIReference found for ssiCode: " + ssiCode));
	}

	@Override
	public List<SSIReferenceDTO> getAll() {
		//return ssiReferenceMapper.toSSIReferenceDTOs(ssiReferenceRepository.findAllByOrderBySSICodeAsc());
		
		List<SSIReference> ssiReferences = ssiReferenceRepository.findAllByOrderBySSICodeAsc();
		
		List<SSIReferenceDTO> ssiReferenceDTOs = ssiReferenceMapper.toSSIReferenceDTOs(ssiReferences);
		
		return ssiReferenceDTOs;
	}

}
