package com.lendico.plangenerator.monthlyplan;

import com.lendico.plangenerator.api.IInstallmentInterestCalculator;
import com.lendico.plangenerator.api.IPMTCalculator;
import com.lendico.plangenerator.api.IRepaymentPlanGenerator;

public class MonthlyPlanGeneratorBuilder {

	private IPMTCalculator pmtCalculator;
	private IInstallmentInterestCalculator interestCalculator;
	
	public MonthlyPlanGeneratorBuilder withDefaultPMTCalculator() {
		this.pmtCalculator = new MonthlyPMTCalculator();
		return this;
	}
	
	public MonthlyPlanGeneratorBuilder withPMTCalculator(IPMTCalculator pmtCalculator) {
		this.pmtCalculator = pmtCalculator;
		return this;
	}
	
	public MonthlyPlanGeneratorBuilder withDefaultInterestRate() {
		this.interestCalculator = new SimpleInstallmentInterestCalculator();
		return this;
	}
	
	public MonthlyPlanGeneratorBuilder withInterestRate(IInstallmentInterestCalculator interestCalculator) {
		this.interestCalculator = interestCalculator;
		return this;
	}
	
	
	public IRepaymentPlanGenerator build() {
		return new MonthlyRepaymentPlanGenerator(this.pmtCalculator, this.interestCalculator);
	}
}
