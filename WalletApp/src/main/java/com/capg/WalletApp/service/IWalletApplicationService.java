package com.capg.WalletApp.service;

import java.util.List;

import com.capg.WalletApp.bean.Customer;



public interface IWalletApplicationService {
	public int createAccount(Customer customer);
	public boolean login(String username, String password);
	public double showBalance();
	public int deposit(double amount);
	public int withdraw(double amount);
	public int fundTransfer(long accNo, double amount);
	public void printTransaction();
	

}
