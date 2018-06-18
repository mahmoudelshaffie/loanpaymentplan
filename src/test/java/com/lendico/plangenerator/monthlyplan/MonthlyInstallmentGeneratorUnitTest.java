package com.lendico.plangenerator.monthlyplan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;

import com.lendico.plangenerator.api.IInstallmentInterestCalculator;
import com.lendico.plangenerator.api.Installment;

public class MonthlyInstallmentGeneratorUnitTest {

	private IInstallmentInterestCalculator simpleInterestCalculator = new SimpleInstallmentInterestCalculator();
	
	@Test
	public void testGeneratInstallmentWithSimpleInterestWithInitialPrincipalGreaterThanAnnuityShouldGenerateSuccessfully() {
		LocalDateTime date = LocalDateTime.of(2017, 01, 01, 0, 0);
		float nominalRate = 5f;
		double PMT = 219.36;
		double initialPrincipal = 5000;
		MonthlyInstallmentGenerator target = new MonthlyInstallmentGenerator(simpleInterestCalculator);
		Installment actual = target.generate(initialPrincipal, PMT, nominalRate, date);
		double expectedAnnuity = PMT;
		double expectedPrincipal = 198.53;
		double expectedInterest = 20.83;
		double expectedRemainingPrincipal = 4801.47;
		assertEquals(initialPrincipal, actual.getInitialOutstandingPrinicipal(), 0.01);
		assertEquals(expectedAnnuity, actual.getAnnuity(), 0);
		assertEquals(expectedPrincipal, actual.getPrincipal(), 0.01);
		assertEquals(expectedInterest, actual.getInterest(), 0.01);
		assertEquals(expectedRemainingPrincipal, actual.getRemainingOutstandingPrinicipal(), 0.01);
		assertNotNull(actual.getDate());
	}
	
	@Test
	public void testGeneratInstallmentWithSimpleInterestAndInitialPrincipalLessThanAnnuityShouldGenerateSuccessfully() {
		LocalDateTime date = LocalDateTime.of(2017, 01, 01, 0, 0);
		float nominalRate = 5f;
		double PMT = 219.36;
		double initialPrincipal = 218.39;
		MonthlyInstallmentGenerator target = new MonthlyInstallmentGenerator(simpleInterestCalculator);
		Installment actual = target.generate(initialPrincipal, PMT, nominalRate, date);
		double expectedAnnuity = 219.36;
		double expectedPrincipal = initialPrincipal;
		double expectedInterest = 0.91;
		double expectedRemainingPrincipal = 0;
		assertEquals(initialPrincipal, actual.getInitialOutstandingPrinicipal(), 0.01);
		assertEquals(expectedAnnuity, actual.getAnnuity(), 0);
		assertEquals(expectedPrincipal, actual.getPrincipal(), 0.01);
		assertEquals(expectedInterest, actual.getInterest(), 0.01);
		assertEquals(expectedRemainingPrincipal, actual.getRemainingOutstandingPrinicipal(), 0.01);
		assertNotNull(actual.getDate());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGeneratInstallmentWithSimpleInterestAndZeroInitialPrincipalShouldThrowsIllegalArgumentException() {
		LocalDateTime date = LocalDateTime.of(2017, 01, 01, 0, 0);
		float nominalRate = 5f;
		double PMT = 219.36;
		double zeroPrincipal = 0;
		MonthlyInstallmentGenerator target = new MonthlyInstallmentGenerator(simpleInterestCalculator);
		target.generate(zeroPrincipal, PMT, nominalRate, date);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGeneratInstallmentWithSimpleInterestAndZeroPMTShouldThrowsIllegalArgumentException() {
		LocalDateTime date = LocalDateTime.of(2017, 01, 01, 0, 0);
		float nominalRate = 5f;
		double zeroPMT = 0;
		double initialPrincipal = 218.39;
		MonthlyInstallmentGenerator target = new MonthlyInstallmentGenerator(simpleInterestCalculator);
		target.generate(initialPrincipal, zeroPMT, nominalRate, date);		
	}
}
