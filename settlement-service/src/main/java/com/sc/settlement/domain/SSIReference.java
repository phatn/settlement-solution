package com.sc.settlement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ssi_reference")
@Data
public class SSIReference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ssi_code", unique = true)
	private String SSICode;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_party_id", nullable = false)
	private PartyAccount payerParty;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver_party_id", nullable = false)
	private PartyAccount receiverParty;
	
	@Column(name = "supporting_information")
	private String supportingInformation;
	

}
