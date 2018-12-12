package com.springboot.pss.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Insurance {

	private String providerName;
	
	@Column(name="copay")
	private double coPayment;

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public double getCoPayment() {
		return coPayment;
	}

	public void setCoPayment(double coPayment) {
		this.coPayment = coPayment;
	}

	@Override
	public String toString() {
		return "Insurance [providerName=" + providerName + ", coPayment=" + coPayment + "]";
	}
}
