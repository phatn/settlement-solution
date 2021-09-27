package com.sc.settlement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sc.settlement.domain.SSIReference;

public interface SSIReferenceRepository extends JpaRepository<SSIReference, Long> {
	
	
	Optional<SSIReference> findBySSICode(String ssiCode);
	
	List<SSIReference> findAllByOrderBySSICodeAsc();

}
