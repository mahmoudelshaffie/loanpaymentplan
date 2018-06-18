package com.lendico.plangenerator.api;

public interface IPMTCalculator {
	/**
	 * Calculate regular payment for loan 
	 * @param initialOutstandingPrincipal starting loan principal
	 * @param nominalRate Nominal Rate
	 * @param duration Loan term in number of months
	 * @return monthly payment for a loan
	 */
	double calculatePTM(double initialOutstandingPrincipal, float nominalRate, int duration) throws IllegalArgumentException;
}
