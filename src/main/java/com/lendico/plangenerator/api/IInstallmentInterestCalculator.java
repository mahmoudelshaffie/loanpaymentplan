package com.lendico.plangenerator.api;

import java.time.LocalDateTime;

/**
 * Calculate interest for installment using formula
 * Interest = (Nominal Rate * Days In Month * Initial Principal)/ DAYS In Year
 * @author shaf3y
 *
 */
public interface IInstallmentInterestCalculator {
	/**
	 * Calculate interest of installment
	 * @param initialPrincipal Initial outstanding principal of installment
	 * @param nominalRate Nominal Rate
	 * @param date Pay-out date of installment
	 * @return
	 */
	double calculate(double initialPrincipal, float nominalRate, LocalDateTime date);
}
