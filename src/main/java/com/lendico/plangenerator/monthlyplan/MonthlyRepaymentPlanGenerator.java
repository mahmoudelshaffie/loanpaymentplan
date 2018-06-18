package com.lendico.plangenerator.monthlyplan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.lendico.plangenerator.api.IInstallmentGenerator;
import com.lendico.plangenerator.api.IInstallmentInterestCalculator;
import com.lendico.plangenerator.api.IPMTCalculator;
import com.lendico.plangenerator.api.IRepaymentPlanGenerator;
import com.lendico.plangenerator.api.Installment;

public class MonthlyRepaymentPlanGenerator implements IRepaymentPlanGenerator {
	
	private IPMTCalculator pmtCalculator;
	private IInstallmentGenerator installmentGenerator;
	
	public MonthlyRepaymentPlanGenerator(IPMTCalculator pmtCalculator, IInstallmentInterestCalculator interestCalculator) {
		this.pmtCalculator = pmtCalculator;
		this.installmentGenerator = new MonthlyInstallmentGenerator(interestCalculator);
	}

	public List<Installment> generate(int duration, float nominalRate, double loanAmount, LocalDateTime startDate) {
		List<Installment> plan = new ArrayList<Installment>(duration);
		double PMT = pmtCalculator.calculatePTM(loanAmount, nominalRate, duration);
		
		Installment firstInstallment = this.installmentGenerator.generate(loanAmount, PMT, nominalRate, startDate);
		plan.add(firstInstallment);
		
		Installment preInstallment = firstInstallment;
		for (int i = 1; i < duration; ++i) {
			startDate = startDate.plusMonths(1); // Returns A Copy
			Installment installment = this.installmentGenerator.generate(preInstallment.getRemainingOutstandingPrinicipal(), PMT, nominalRate, startDate);
			plan.add(installment);
			preInstallment = installment;
		}
		
		return plan;
	}

}
