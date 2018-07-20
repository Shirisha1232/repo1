package com.capg.WalletApp.bean;

public class Customer {
	
	
		
		private String firstName;
	    private String gender;
		private String contact;
		private String email;
		private int age;
		private long aadharNo;
		private String userName;
		private String password;
		private WalletApplicationData wallet;
		
		public WalletApplicationData getWallet() {
			return wallet;
		}
		public void setWallet(WalletApplicationData wallet) {
			this.wallet = wallet;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public  String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public long getAadharNo() {
			return aadharNo;
		}
		public void setAadharNo(long aadharNo) {
			this.aadharNo = aadharNo;
		}
		@Override
		public String toString() {
			return "Customer [firstName=" + firstName + ",  gender=" + gender + ", contact="
					+ contact + ", email=" + email + ", age=" + age + ", aadharNo=" + aadharNo + ", userName=" + userName
					+ ", password=" + password + "]";
		}
		
		
		
		
		
		

	}



