package com.TeleMessage.model;

import java.util.Date;

public class PhoneNumber {
	
	private String mdn;
	private String transactionId;
	private String type;
	private Date requestReceivedDate;
	private int currentStatus;
	private String statusInfo;
	
	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getRequestReceivedDate() {
		return requestReceivedDate;
	}
	public void setRequestReceivedDate(Date date) {
		this.requestReceivedDate = date;
	}
	public int getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getStatusInfo() {
		return statusInfo;
	}
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
	
	

}
