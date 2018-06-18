package com.lendico.plangenerator.api;

import java.time.LocalDateTime;

public interface IInstallmentGenerator {
	Installment generate(double initialOutstandingPrinicipal, double PMT, float nominalRate, LocalDateTime date);
}
