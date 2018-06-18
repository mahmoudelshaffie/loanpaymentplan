package com.lendico.plangenerator.api;

import java.time.LocalDateTime;

public class Installment {
	private Double annuity;
	private LocalDateTime date;
	private Double initialOutstandingPrinicipal;
	private Double interest;
	private Double principal;
	private Double remainingOutstandingPrinicipal;
	
	public Installment() {
	}
	
	public Installment(Double annuity, LocalDateTime date, Double initialOutstandingPrinicipal, Double interest,
			Double principal, Double remainingOutstandingPrinicipal) {
		super();
		this.annuity = annuity;
		this.date = date;
		this.initialOutstandingPrinicipal = initialOutstandingPrinicipal;
		this.interest = interest;
		this.principal = principal;
		this.remainingOutstandingPrinicipal = remainingOutstandingPrinicipal;
	}

	public Double getAnnuity() {
		return annuity;
	}

	public void setAnnuity(Double annuity) {
		this.annuity = annuity;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getInitialOutstandingPrinicipal() {
		return initialOutstandingPrinicipal;
	}

	public void setInitialOutstandingPrinicipal(Double initialOutstandingPrinicipal) {
		this.initialOutstandingPrinicipal = initialOutstandingPrinicipal;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getRemainingOutstandingPrinicipal() {
		return remainingOutstandingPrinicipal;
	}

	public void setRemainingOutstandingPrinicipal(Double remainingOutstandingPrinicipal) {
		this.remainingOutstandingPrinicipal = remainingOutstandingPrinicipal;
	}
}
