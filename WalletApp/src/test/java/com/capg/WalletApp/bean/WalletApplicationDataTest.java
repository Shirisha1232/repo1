package com.capg.WalletApp.bean;

import java.time.LocalDate;



import junit.framework.TestCase;

public class WalletApplicationDataTest extends TestCase {
WalletApplicationData bean = new WalletApplicationData();

	

	public void testGetDate() {
		assertNull(bean.getDate());
		assertFalse(bean.getDate() == LocalDate.now());
		bean.setDate(LocalDate.now());
		assertEquals(LocalDate.now(), bean.getDate());
	}

	public void testGetAccNo() {
		bean.setAccNo(1234567890);
		assertTrue(1234567890 == bean.getAccNo());
		assertFalse(123490890 == bean.getAccNo());
		
	}

	

	
	
	
	public void testGetAccount() {
		bean.setAmount(4500);
		assertFalse(5500 == bean.getAmount());
		assertTrue(4500 == bean.getAmount());
	}


}
