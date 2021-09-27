package com.sc.settlement.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "settlement")
@Data
public class Settlement {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "trade_id", unique = true, nullable = false)
	private Long tradeId;
	
	@Column(name = "message_id", nullable = false)
	private String messageId;
	
	@Column(name = "amount", nullable = false)
	private Double amount;
	
	@Column(name = "value_date", nullable = false)
	private LocalDate valueDate;
	
	@ManyToOne
	@JoinColumn(name = "ssi_code", nullable = false)
	private SSIReference ssiReference;

	@ManyToOne
	@JoinColumn(name = "currency_id", nullable = false)
	private Currency currency;

}
