package org.example.thortfultask.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdviceResponse {
	private Advice slip;

	// Getters and Setters
	public Advice getSlip() {
		return this.slip;
	}

	public void setSlip(final Advice slip) {
		this.slip = slip;
	}
}
