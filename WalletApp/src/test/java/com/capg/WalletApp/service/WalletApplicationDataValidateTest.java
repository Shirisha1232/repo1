package com.capg.WalletApp.service;

import com.capg.WalletApp.bean.Customer;
import com.capg.WalletApp.bean.WalletApplicationData;

import junit.framework.TestCase;

public class WalletApplicationDataValidateTest extends TestCase {
	WalletApplicationData bean = new WalletApplicationData();
	WalletApplicationDataValidate validate = new WalletApplicationDataValidate();
	 Customer cust = new Customer();                                                                       

	public void testValidateFirstName() {
		cust.setFirstName("shirisha");
		assertNotNull(cust.getFirstName());
		assertEquals(true, validate.validateFirstName(cust.getFirstName()));
	}

	

	public void testValidateGender() {
		cust.setGender("Female");
		assertNotNull(cust.getGender());
		assertEquals(true, validate.validateGender(cust.getGender()));
	}

	public void testValidateContact() {
		cust.setContact("7396648386");
		assertNotNull(cust.getContact());
		assertEquals(true, validate.validateContact(cust.getContact()));
	}

	public void testValidateEmail() {
		cust.setEmail("shirisha@gmail.com");
		assertNotNull(cust.getEmail());
		assertEquals(true, validate.validateEmail(cust.getEmail()));
	}

	public void testValidateAccNo() {
		bean.setAccNo(1256789021);
		assertNotNull(bean.getAccNo());
		//assertEquals(true,bean.getAccNo());
	}

	public void testValidateUserName() {
		cust.setUserName("Shirisha1232");
		assertNotNull(cust.getUserName());
		assertEquals(false, validate.validateUserName(cust.getUserName()));
	}

	public void testValidatePassword() {
		cust.setPassword("Siri@1234");
		assertNotNull(cust.getPassword());
		assertEquals(false, validate.validatePassword(cust.getPassword()));
	}

	
}
