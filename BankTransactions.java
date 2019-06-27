package com.cg.bvrit.bean;

import java.util.Date;

public class BankTransactions {

	private int transId;
	private long accNoFrom;
	private long accNoTo;
	private double amount;
	private Date dateOfTrans;
	private String transType;
	private double balance;
	
	
	public BankTransactions(int transId, long accNoFrom, long accNoTo, double amount, Date dateOfTrans,
			String transType, double balance) {
		super();
		this.transId = transId;
		this.accNoFrom = accNoFrom;
		this.accNoTo = accNoTo;
		this.amount = amount;
		this.dateOfTrans = dateOfTrans;
		this.transType = transType;
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "EWalletTransDetails [transId=" + transId + ", accNoFrom=" + accNoFrom + ", accNoTo=" + accNoTo
				+ ", amount=" + amount + ", dateOfTrans=" + dateOfTrans + ", transType=" + transType + ", balance="
				+ balance + "]";
	}


	public BankTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getTransId() {
		return transId;
	}


	public void setTransId(int transId) {
		this.transId = transId;
	}


	public long getAccNoFrom() {
		return accNoFrom;
	}


	public void setAccNoFrom(long accNoFrom) {
		this.accNoFrom = accNoFrom;
	}


	public long getAccNoTo() {
		return accNoTo;
	}


	public void setAccNoTo(long accNoTo) {
		this.accNoTo = accNoTo;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getDateOfTrans() {
		return dateOfTrans;
	}


	public void setDateOfTrans(Date dateOfTrans) {
		this.dateOfTrans = dateOfTrans;
	}


	public String getTransType() {
		return transType;
	}


	public void setTransType(String transType) {
		this.transType = transType;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
	
	
	
}
