package com.cg.bvrit.bean;

public class BankDetalils {

	private long accNo;
	private String custName;
	private long mobile;
	private String accType;
	private String branch;
	private double balance;
	
	public BankDetalils() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", custName=" + custName + ", mobile=" + mobile + ", accType=" + accType
				+ ", branch=" + branch + ", balance=" + balance + "]";
	}
	
	public BankDetalils(long accNo, String custName, long mobile, String accType, String branch, double balance) {
		super();
		this.accNo = accNo;
		this.custName = custName;
		this.mobile = mobile;
		this.accType = accType;
		this.branch = branch;
		this.balance = balance;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
