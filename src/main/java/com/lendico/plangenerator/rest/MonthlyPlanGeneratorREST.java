package com.lendico.plangenerator.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lendico.plangenerator.api.IInstallmentInterestCalculator;
import com.lendico.plangenerator.api.IPMTCalculator;
import com.lendico.plangenerator.api.IRepaymentPlanGenerator;
import com.lendico.plangenerator.api.Installment;
import com.lendico.plangenerator.monthlyplan.MonthlyPMTCalculator;
import com.lendico.plangenerator.monthlyplan.MonthlyRepaymentPlanGenerator;
import com.lendico.plangenerator.monthlyplan.SimpleInstallmentInterestCalculator;

@RestController
@RequestMapping("/generate-plan")
public class MonthlyPlanGeneratorREST {

	
	private IRepaymentPlanGenerator planGenerator;
	
	public MonthlyPlanGeneratorREST() {
		IPMTCalculator pmtCalculator = new MonthlyPMTCalculator();
		IInstallmentInterestCalculator interestCalculator = new SimpleInstallmentInterestCalculator();
		this.planGenerator = new MonthlyRepaymentPlanGenerator(pmtCalculator, interestCalculator);
	}
	
	@PostMapping
	public List<Installment> generatePlan(@RequestBody LoanConfig config) {
		LocalDateTime startDate = config.getStartDate();
		double loanAmount = config.getLoanAmount();
		float nominalRate = config.getNominalRate();
		int duration = config.getDuration();
		return this.planGenerator.generate(duration, nominalRate, loanAmount, startDate);
	}
}
