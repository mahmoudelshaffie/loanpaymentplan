package com.lendico.plangenerator.monthlyplan;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lendico.plangenerator.monthlyplan.MonthlyPMTCalculator;

public class MonthlyPMTCalculatorUnitTest {

	@Test
	public void testCalculatePTMWithValidArgumentsShouldCalculatePTMSuccessfully() {
		double initialPrincipal = 5000;
		float interest = 5f;
		int duration = 24;
		MonthlyPMTCalculator targetCalculator = new MonthlyPMTCalculator();
		double actual = targetCalculator.calculatePTM(initialPrincipal, interest, duration);
		double expected = 219.36;
		assertEquals(expected, actual, 0.01); //Delta:0.01 due too rounding 
	}
	
	@Test
	public void testCalculatePTMWithZeroInitialPrinicipalShouldReturnZeroSuccessfully() {
		double initialPrincipal = 0;
		float interest = 5f;
		int duration = 24;
		MonthlyPMTCalculator targetCalculator = new MonthlyPMTCalculator();
		double actual = targetCalculator.calculatePTM(initialPrincipal, interest, duration);
		double expected = 0;
		assertEquals(expected, actual, 0); //Delta:0.01 due too rounding 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalculatePTMWithNegativeInitialPrinicipalShouldFailsAndThrowsIllegalArgumentException() {
		double initialPrincipal = -4556;
		float interest = 5f;
		int duration = 24;
		MonthlyPMTCalculator targetCalculator = new MonthlyPMTCalculator();
		targetCalculator.calculatePTM(initialPrincipal, interest, duration);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalculatePTMWithNegativeInterestlShouldFailsAndThrowsIllegalArgumentException() {
		double initialPrincipal = 4556;
		float interest = -5f;
		int duration = 24;
		MonthlyPMTCalculator targetCalculator = new MonthlyPMTCalculator();
		targetCalculator.calculatePTM(initialPrincipal, interest, duration);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalculatePTMWithZeroInterestlShouldFailsAndThrowsIllegalArgumentException() {
		double initialPrincipal = 4556;
		float interest = 0f;
		int duration = 24;
		MonthlyPMTCalculator targetCalculator = new MonthlyPMTCalculator();
		targetCalculator.calculatePTM(initialPrincipal, interest, duration);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalculatePTMWithNegativeDurationShouldFailsAndThrowsIllegalArgumentException() {
		double initialPrincipal = 4556;
		float interest = 1.5f;
		int duration = -24;
		MonthlyPMTCalculator targetCalculator = new MonthlyPMTCalculator();
		targetCalculator.calculatePTM(initialPrincipal, interest, duration);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalculatePTMWithZeroDurationShouldFailsAndThrowsIllegalArgumentException() {
		double initialPrincipal = 4556;
		float interest = 1.5f;
		int duration = -24;
		MonthlyPMTCalculator targetCalculator = new MonthlyPMTCalculator();
		targetCalculator.calculatePTM(initialPrincipal, interest, duration);
	}
}
