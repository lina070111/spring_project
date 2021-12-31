package com.spring.project.vo;

public class SubscribeVO {

	private int subseq;
	private String id;
	private int payment;
	private String payment_date;
	private int period;
	private String start_date;
	private String end_date;
	
	public SubscribeVO() {
	}

	public SubscribeVO(int subseq, String id, int payment, String payment_date, int period, String start_date,
			String end_date) {
		super();
		this.subseq = subseq;
		this.id = id;
		this.payment = payment;
		this.payment_date = payment_date;
		this.period = period;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getSubseq() {
		return subseq;
	}

	public void setSubseq(int subseq) {
		this.subseq = subseq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "SubscribeVO [subseq=" + subseq + ", id=" + id + ", payment=" + payment + ", payment_date="
				+ payment_date + ", period=" + period + ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}
	
	

	
}
