package com.lambdaschool.schools.models;

public class AdviceSlip {
	private long slip_id;
	private String advice;

	public long getSlip_id() {
		return slip_id;
	}

	public void setSlip_id(long slip_id) {
		this.slip_id = slip_id;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	@Override
	public String toString() {
		return "AdviceSlip{" +
			"slip_id=" + slip_id +
			", advice='" + advice + '\'' +
			'}';
	}
}
