package com.lendico.plangenerator.monthlyplan;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

public class SimplyInstallmentInterestCalculatorUnitTest {

	private final LocalDateTime date = LocalDateTime.of(2017, 01, 01, 0, 0);

	@Test
	public void testCalculateInterestShouldReturnExpectedInterestSuccessfully() {
		SimpleInstallmentInterestCalculator target = new SimpleInstallmentInterestCalculator();
		double initialPrincipal = 5000;
		float nominalRate = 5f;
		double actual = target.calculate(initialPrincipal, nominalRate, date );
		double expected = 20.83;
		assertEquals(expected, actual, 0.01);
		
	}
	
	@Test
	public void testCalculateInterestWithZeroPrincipalShouldReturnZeroSuccessfully() {
		SimpleInstallmentInterestCalculator target = new SimpleInstallmentInterestCalculator();
		double zeroPrincipal = 0;
		float nominalRate = 5f;
		double actual = target.calculate(zeroPrincipal, nominalRate, date );
		double zeroExpected = 0;
		assertEquals(zeroExpected, actual, 0);
	}
	
	@Test
	public void testCalculateInterestWithZeroNominalRateShouldReturnZeroSuccessfully() {
		SimpleInstallmentInterestCalculator target = new SimpleInstallmentInterestCalculator();
		double initialPrincipal = 5000;
		float nominalRate = 0f;
		double actual = target.calculate(initialPrincipal, nominalRate, date );
		double zeroExpected = 0;
		assertEquals(zeroExpected, actual, 0);
	}
}
