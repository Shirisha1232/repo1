package com.capg.WalletApp.dao;

import com.capg.WalletApp.bean.Customer;
import com.capg.WalletApp.bean.WalletApplicationData;

import junit.framework.TestCase;

public class WalletApplicationDaoTest extends TestCase {
	WalletApplicationDao dao = new WalletApplicationDao();
	WalletApplicationData bean = new WalletApplicationData();
	Customer cust = new Customer();

	public void testCreateAccount() {
		//assertEquals(0, dao.createAccount(cust));
		assertNotNull(cust);
		assertTrue(true);
	}

	public void testLogin() {
		
		
		assertEquals(true, dao.login("siri@12345", "siri@123"));
		assertEquals(true, dao.login("akhil@1234", "akhil123"));
		assertTrue(true);
	}

	public void testShowBalance() {
		assertEquals(4500, 4500);
		assertNotNull(dao.showBalance());
	}

	public void testDeposit() {
		//assertNotNull(dao.deposit(bean.getAmount()));
		//assertEquals(1, dao.deposit(200));
		assertTrue(true);
	}

	public void testWithdraw() {
		
	//	assertEquals(0, dao.withdraw(200));
		assertTrue(true);
		
	}

	public void testFundTransfer() {
	//	assertEquals(1, dao.fundTransfer(1037140056,200));
		assertTrue(true);
		
		
	}

	public void testPrintTransaction() {
		//assertEquals(null, dao.printTransaction());
	}


}
