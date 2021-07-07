package com.ufinity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufinity.repository.UfinityCalculatorDatabase;
import com.ufinity.repository.UfinityCalculatorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UfinityCalculateService {
	
	@Autowired
	UfinityCalculatorRepository calculatorRepository;
	
	public void calculate(UfinityCalculatorDatabase calculator) {
		try {
		if(calculator.getOperationType().equalsIgnoreCase("Addition")) {
			calculator.setResult(calculator.getNumber1() + calculator.getNumber2());
		}
		
		if(calculator.getOperationType().equalsIgnoreCase("Subtraction")) {
			calculator.setResult(calculator.getNumber1() - calculator.getNumber2());
		}
		
        java.sql.Timestamp sqlTS = new java.sql.Timestamp(new java.util.Date().getTime());
        calculator.setTransactionTime(sqlTS);
		calculatorRepository.save(calculator);
		}catch(Exception exception) {
			log.error("Exception in UfinityService :: "+exception.getMessage());
			throw new IllegalArgumentException("Exception in UfinityCalculateService :: "+exception.getMessage());
		}
	}

}
