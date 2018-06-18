package com.lendico.plangenerator.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepaymentPlanGenerator {
	List<Installment> generate(int duration, float nominalRate, double loanAmount, LocalDateTime startDate);
}
