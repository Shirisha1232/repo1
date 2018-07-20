package com.capg.WalletApp.bean;



import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	Customer cust = new Customer();

	public void testGetUserName() {
		cust.setUserName("Shirisha1232");
		assertEquals("Shirisha1232",cust.getUserName());
	}



	public void testGetPassword() {
		cust.setPassword("Siri@1232");
		assertEquals("Siri@1232",cust.getPassword());
		
	}


	public void testGetFirstName() {
		cust.setFirstName("shirisha");
		assertEquals("shirisha", cust.getFirstName());
		assertTrue("shirisha".equalsIgnoreCase(cust.getFirstName()));
		assertNotNull(cust);
	}

	

	

	

	public void testGetGender() {
		cust.setGender("female");
		assertFalse("male".equalsIgnoreCase(cust.getGender()));
		assertTrue("female".equalsIgnoreCase(cust.getGender()));
	}

	

	public void testGetContact() {
		cust.setContact("7396648386");
		assertFalse("7396642314".equals(cust.getContact()));
		assertTrue("7396648386".equals(cust.getContact()));
	}

	

	public void testGetEmail() {
		cust.setEmail("shirisha@gmail.com");
		assertEquals("shirisha@gmail.com",cust.getEmail());
	
	}



	public void testGetAge() {
		cust.setAge(23);
		assertEquals(23, cust.getAge());
	}

	
	public void testGetAadharNo() {
		cust.setAadharNo(1235467890);
		long aadhar = cust.getAadharNo();
		assertEquals(1235467890,aadhar);
		//assertFalse("1246467890".equals(cust.getAadharNo()));
		
	}

	


}
