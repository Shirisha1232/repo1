package com.capg.WalletApp.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class WalletApplicationData {

	
	private long accNo;
	private LocalDate date;
	private long aadhar_no;
	private String branch;
	private double amount;
	private String account_type;
	
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public long getAadhar_no() {
		return aadhar_no;
	}
	public void setAadhar_no(long aadhar_no) {
		this.aadhar_no = aadhar_no;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	@Override
	public String toString() {
		return "WalletApplicationData [accNo=" + accNo + ", date=" + date + ", aadhar_no=" + aadhar_no + ", branch="
				+ branch + ", amount=" + amount + ", account_type=" + account_type + "]";
	}
	
	
	
	
	
	

}
