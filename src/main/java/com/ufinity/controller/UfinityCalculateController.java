package com.ufinity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.ufinity.repository.UfinityCalculatorDatabase;
import com.ufinity.service.UfinityCalculateService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UfinityCalculateController {
	
	@Autowired
	UfinityCalculateService calculateService;
	
	
	@PostMapping("/addition")
	@ResponseBody
	public UfinityCalculatorDatabase addition(@RequestBody UfinityCalculatorDatabase calculator) {
		calculator.setOperationType("Addition");
		calculateService.calculate(calculator);
		log.info("Calculate Res :: "+calculator.getResult());
		return calculator;
	}
	
	
	@PostMapping("/subtraction")
	@ResponseBody
	public UfinityCalculatorDatabase subtraction(@RequestBody UfinityCalculatorDatabase calculator) {
		calculator.setOperationType("Subtraction");
		calculateService.calculate(calculator);
		
		return calculator;
		
	}
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<UfinityCalculatorDatabase> handleAllExceptions(Exception ex, WebRequest request) {
        log.info("Exception  ......******** "+ex.getLocalizedMessage());
        UfinityCalculatorDatabase error = new UfinityCalculatorDatabase();
        error.setError(ex.getMessage());
        return new ResponseEntity<UfinityCalculatorDatabase>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
