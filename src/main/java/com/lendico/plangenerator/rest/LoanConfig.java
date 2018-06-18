package com.lendico.plangenerator.rest;

import java.time.LocalDateTime;

public class LoanConfig {
	private double loanAmount;
	private float nominalRate;
	private int duration;
	private LocalDateTime startLocalDateTime;
	
	public double getLoanAmount() {
		return loanAmount;
	}
	
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public float getNominalRate() {
		return nominalRate;
	}
	
	public void setNominalRate(float nominalRate) {
		this.nominalRate = nominalRate;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public LocalDateTime getStartDate() {
		return startLocalDateTime;
	}
	
	public void setStartDate(LocalDateTime startLocalDateTime) {
		this.startLocalDateTime = startLocalDateTime;
	}
	
	
}
