package com.lendico.plangenerator.monthlyplan;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import com.lendico.plangenerator.api.IInstallmentInterestCalculator;
import com.lendico.plangenerator.api.IPMTCalculator;
import com.lendico.plangenerator.api.IRepaymentPlanGenerator;
import com.lendico.plangenerator.api.Installment;

public class MonthlyPlanGeneratorTest {

	private IPMTCalculator pmtCalculator = new MonthlyPMTCalculator();
	private IInstallmentInterestCalculator interestCalculator = new SimpleInstallmentInterestCalculator();
	
	private void assertFirstPayment(Installment actual) {
		double expectedAnnuity = 219.36;
		double expectedInterest = 20.83;
		double expectedPrinciple = 198.52;
		double expectedRemainingPrincipal = 4801.48;
		double expectedInitialBalance = 5000;
		double expectedMonth = 01;
		double expectedYear = 2017;
		assertEquals(expectedAnnuity, actual.getAnnuity(), 0.01);
		assertEquals(expectedInterest, actual.getInterest(), 0.01);
		assertEquals(expectedPrinciple, actual.getPrincipal(), 0.01);
		assertEquals(expectedRemainingPrincipal, actual.getRemainingOutstandingPrinicipal(), 0.01);
		assertEquals(expectedInitialBalance, actual.getInitialOutstandingPrinicipal(), 0.01);
		assertEquals(expectedMonth, actual.getDate().getMonthValue(), 0);
		assertEquals(expectedYear, actual.getDate().getYear(), 0);
	}
	
	private void assertSecondPayment(Installment actual) {
		double expectedAnnuity = 219.36;
		double expectedInterest = 20.01;
		double expectedPrinciple = 199.35;
		double expectedRemainingPrincipal = 4602.13;
		double expectedInitialBalance = 4801.48;
		double expectedMonth = 02;
		double expectedYear = 2017;
		assertEquals(expectedAnnuity, actual.getAnnuity(), 0.01);
		assertEquals(expectedInterest, actual.getInterest(), 0.01);
		assertEquals(expectedPrinciple, actual.getPrincipal(), 0.01);
		assertEquals(expectedRemainingPrincipal, actual.getRemainingOutstandingPrinicipal(), 0.01);
		assertEquals(expectedInitialBalance, actual.getInitialOutstandingPrinicipal(), 0.01);
		assertEquals(expectedMonth, actual.getDate().getMonthValue(), 0);
		assertEquals(expectedYear, actual.getDate().getYear(), 0);
	}
	
	private void assertLastPayment(Installment actual) {
		double expectedAnnuity = 219.36;
		double expectedInterest = 0.91;
		double expectedPrinciple = 218.45;
		double expectedRemainingPrincipal = 0;
		double expectedInitialBalance = 218.45;
		double expectedMonth = 12;
		double expectedYear = 2018;
		assertEquals(expectedAnnuity, actual.getAnnuity(), 0.01);
		assertEquals(expectedInterest, actual.getInterest(), 0.01);
		assertEquals(expectedPrinciple, actual.getPrincipal(), 0.01);
		assertEquals(expectedRemainingPrincipal, actual.getRemainingOutstandingPrinicipal(), 0.01);
		assertEquals(expectedInitialBalance, actual.getInitialOutstandingPrinicipal(), 0.01);
		assertEquals(expectedMonth, actual.getDate().getMonthValue(), 0);
		assertEquals(expectedYear, actual.getDate().getYear(), 0);
	}
	
	@Test
	public void testGeneratePlanSuccessfully() {
		LocalDateTime date = LocalDateTime.of(2017, 01, 01, 0, 0);
		int duration = 24;
		float nominalRate = 5f;
		IRepaymentPlanGenerator planGenerator = new MonthlyRepaymentPlanGenerator(pmtCalculator, interestCalculator);
		List<Installment> plan = planGenerator.generate(duration, nominalRate, 5000, date);
		assertEquals(plan.size(), duration);
		assertFirstPayment(plan.get(0));
		assertSecondPayment(plan.get(1));
		assertLastPayment(plan.get(duration - 1));
	}
}
