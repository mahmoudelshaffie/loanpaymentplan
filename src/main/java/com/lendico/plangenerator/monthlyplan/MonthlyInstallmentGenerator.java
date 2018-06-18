package com.lendico.plangenerator.monthlyplan;

import java.time.LocalDateTime;

import com.lendico.plangenerator.api.IInstallmentGenerator;
import com.lendico.plangenerator.api.IInstallmentInterestCalculator;
import com.lendico.plangenerator.api.Installment;

public class MonthlyInstallmentGenerator implements IInstallmentGenerator {

	private IInstallmentInterestCalculator interestCalculator;
	
	public MonthlyInstallmentGenerator(IInstallmentInterestCalculator interestCalculator) {
		this.interestCalculator = interestCalculator;
	}
	
	public Installment generate(double initialOutstandingPrinicipal, double PMT, float nominalRate, LocalDateTime date) throws IllegalArgumentException {
		if (PMT <= 0) {
			throw new IllegalArgumentException("PMT Should be greater than 0");
		}
		
		if (initialOutstandingPrinicipal <= 0) {
			throw new IllegalArgumentException("Initial Principal Should Be Greater Than 0");
		}
		
		double annuity = PMT;
		double interest = this.interestCalculator.calculate(initialOutstandingPrinicipal, nominalRate, date);
		
		double principal = annuity - interest;
		principal = principal >= initialOutstandingPrinicipal ? initialOutstandingPrinicipal : principal;
		
		double remainingOutstandingPrinicipal = initialOutstandingPrinicipal - principal;
		if (remainingOutstandingPrinicipal < 0) {
			remainingOutstandingPrinicipal = 0;
			annuity = principal + interest;
		}
		
		return new Installment(annuity, date, initialOutstandingPrinicipal, interest, principal, remainingOutstandingPrinicipal);
	}
	
}
