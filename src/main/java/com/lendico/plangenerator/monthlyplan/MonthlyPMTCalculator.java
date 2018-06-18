package com.lendico.plangenerator.monthlyplan;

import com.lendico.plangenerator.api.IPMTCalculator;

/**
 * See: http://financeformulas.net/Annuity_Payment_Formula.html
 * Calculate Monthly payment for a loan using PMT Formula 
 *				P * (APR / n)				
 * PMT	= -----------------------------		
 *		  [ 1 - ((1 + (APR / n)) ^ -d )]
 * 
 * Where:
 *  PMT = regular payment amount
 *  n = number of payments per year
 *  APR = Annual Percentage Rate (nominal rate)
 *  n = number of payments per year
 *  d = loan term in number of months
 * @author shaf3y
 *
 */
public class MonthlyPMTCalculator implements IPMTCalculator {
	// Number of payments per year
	private final int n = 12; // Monthly payment

	public double calculatePTM(double initialPrincipal, float nominalRate, int duration) {
		if (initialPrincipal < 0) {
			throw new IllegalArgumentException("Invalid Initial Principal: It should be greater than or equal Zero");
		}
		
		if (nominalRate <= 0) {
			throw new IllegalArgumentException("Invalid Nominal Rate: It should be greater than Zero");
		}
		
		if (duration <= 0) {
			throw new IllegalArgumentException("Invalid Loan Duration: It should be greater than Zero");
		}
		
		double P = initialPrincipal;
		float APR = nominalRate/100;
		int d = duration;
		double periodRate = APR/n; // (APR / n)
		
		// Calculating negative exponent ((1 + (APR / n)) ^ -d )
		double base = 1 + periodRate; // (1 + (APR / n))
		int exponent = duration * -1; // -d 
		double negativeExponent = Math.pow(base, exponent);
		
		//Calculate divisor 1 - negativeExponent "[ 1 - ((1 + (APR / n)) ^ -d )]" 
		double divisor = 1 - negativeExponent;
		divisor = divisor > 0 ? divisor : (divisor * -1);
		
		double PMT = ((P * periodRate)/ divisor);
		return PMT;
	}

}
