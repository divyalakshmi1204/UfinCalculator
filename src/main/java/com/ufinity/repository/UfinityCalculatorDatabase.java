package com.ufinity.repository;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "UFINITY_CALCULATOR")
@Data
public class UfinityCalculatorDatabase{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UFINITY_CALCULATOR_ID")
	private Long ufinityCalculatorId;
	
	@Column(name="OPERATION_TYPE")
	private String operationType;
	
	@Column(name="NUMBER_1")
	private Long number1;
	
	@Column(name="NUMBER_2")
	private Long number2;
	
	@Column(name="RESULT")
	private Long result;
	
	@Column(name="TransactionTime")
	private Timestamp transactionTime;
	
	@Transient
	private String error;
}
