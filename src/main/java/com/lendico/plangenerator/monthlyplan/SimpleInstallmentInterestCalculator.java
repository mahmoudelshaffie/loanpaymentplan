package com.lendico.plangenerator.monthlyplan;

import java.time.LocalDateTime;

import com.lendico.plangenerator.api.IInstallmentInterestCalculator;

/**
 * Provides simple implementation of Installment's Interest Calculator.
 * It follows the following day convention:
 * 	- Each month has 30 days.
 *  - A year has 360 days.
 * @author shaf3y

 */
public class SimpleInstallmentInterestCalculator implements IInstallmentInterestCalculator {
	
	private final byte daysInMonth = 30;
	private final short daysInYear = 360;

	public double calculate(double initialPrincipal, float nominalRate, LocalDateTime date) {
		double interest = (initialPrincipal * nominalRate * this.daysInMonth) / this.daysInYear;
		interest = interest / 100; // Cents
		return interest;
	}

}
