package com.sc.settlement.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.sc.settlement.api.settlement.SSIReferenceDTO;
import com.sc.settlement.domain.SSIReference;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SSIReferenceMapper {
	
	SSIReferenceDTO toSSIReferenceDTO(SSIReference ssiReference);
	
	List<SSIReferenceDTO> toSSIReferenceDTOs(List<SSIReference> ssiReferences);
}
