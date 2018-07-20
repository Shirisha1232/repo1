package com.capg.WalletApp.service;

public class WalletApplicationDataValidate {
	public boolean validateFirstName(String firstName) {
		if(firstName.isEmpty())
			return false;
		return true;
		
	}
	public boolean validateLastName(String lastName) {
		if(lastName.isEmpty())
			return false;
		return true;
	}
	public boolean validateGender(String gender) {
		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))
			return true;
		return false;
	}
	public boolean validateContact(String contact) {
		if(contact.length() == 10 )
			return true;
		return false;
	}
	public boolean validateEmail(String email) {
		if(email.endsWith("@gmail.com"))
			return true;
		return false;
	}
	
	
	public boolean validateUserName(String username) {
		if(username.length() == 10) {
			return true;
		}
		return false;
	}
	
	public boolean validatePassword(String password) {
		if(password.length() == 8)
			return true;
		return false;
	}
	


}
