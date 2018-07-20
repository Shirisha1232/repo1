package com.capg.WalletApp.service;

import java.util.List;

import com.capg.WalletApp.bean.Customer;
import com.capg.WalletApp.dao.WalletApplicationDao;

public class WalletApplicationService implements IWalletApplicationService{
	WalletApplicationDao dao = new WalletApplicationDao();

	public int createAccount(Customer customer) {
		// TODO Auto-generated method stub
		return dao.createAccount(customer);
	}

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username, password);
	}

	public double showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	public int deposit(double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}

	public int fundTransfer(long accNo, double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(accNo, amount);
	}

	public void printTransaction() {
		// TODO Auto-generated method stub
		dao.printTransaction();
	}
	

}
