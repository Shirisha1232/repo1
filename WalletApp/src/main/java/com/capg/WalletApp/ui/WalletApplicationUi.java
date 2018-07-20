package com.capg.WalletApp.ui;



	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capg.WalletApp.bean.Customer;
import com.capg.WalletApp.bean.WalletApplicationData;
import com.capg.WalletApp.service.WalletApplicationDataValidate;
import com.capg.WalletApp.service.WalletApplicationService;
public class WalletApplicationUi {
	
		static long accNo = 0;
		static int n = 0;
		
		public static void create() {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			WalletApplicationData bean = new WalletApplicationData();
			Customer cust = new Customer();
			WalletApplicationDataValidate validate = new WalletApplicationDataValidate();
			WalletApplicationService service = new WalletApplicationService();
			try {
				System.out.println("Enter your name");
				String firstName = br.readLine();
				
			    System.out.println("Enter your gender");
				String gender = br.readLine();
				
				System.out.println("Enter your age");
				String age = br.readLine();
				
				System.out.println("Enter your contact");
				String contact = br.readLine();
				
				System.out.println("Enter your email-id");
				String email = br.readLine();
				
				System.out.println("Enter your aadhar");
				String aadharNo = br.readLine();
				
				System.out.println("Enter your username");
				String userName = br.readLine();
				
				System.out.println("Enter your password");
				String password = br.readLine();
				
				accNo =  (long)(Math.random()*123456789) + 999999999;
				
				
				LocalDate date = LocalDate.now();
				
				System.out.println("Enter the amount");
				String amount = br.readLine();
				
				System.out.println("Enter Acoount type(savings/current)");
				String account_type = br.readLine();
				
				cust.setFirstName(firstName);
				cust.setGender(gender);
				cust.setAge(Integer.parseInt(age));
				cust.setContact(contact);
				cust.setEmail(email);
				cust.setAadharNo(Long.parseLong(aadharNo));
				cust.setUserName(userName);
				cust.setPassword(password);
				
				
				bean.setAccNo(accNo);
				bean.setDate(date);
				bean.setAadhar_no(Long.parseLong(aadharNo));
				bean.setAmount(Double.parseDouble(amount));
				bean.setAccount_type(account_type);
				bean.setBranch("Gachibowli");
				
				cust.setWallet(bean);
				
				boolean isValidFirstName = validate.validateFirstName(firstName);
				
				boolean isValidGender = validate.validateGender(gender);
				boolean isValidContact = validate.validateContact(contact);
				boolean isValidEmail = validate.validateEmail(email);
				boolean isValidUserName = validate.validateUserName(userName);
				boolean isValidPassword = validate.validatePassword(password);
				
				if(isValidFirstName && isValidGender &&  isValidContact &&  isValidEmail && isValidUserName && isValidPassword)
					n = service.createAccount(cust);
				if(n==1) {
					System.out.println("Your acount is successfully created");
					System.out.println("your account number: " +accNo);
				}
				else {
					System.out.println("Account is not created");
				}
					
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public static void signin() {
			WalletApplicationService service = new WalletApplicationService();
			WalletApplicationData bean = new WalletApplicationData();
			int ch = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your username");
			String userName = sc.next();
			System.out.println("Enter your password");
			String password = sc.next();
			boolean valid = service.login(userName, password);
			if(valid)
				System.out.println("Logged in succesfully");
			do {
			if(valid) {
				System.out.println("*********************");
				System.out.println("1.show balance");
				System.out.println("2.deposit");
				System.out.println("3.withdraw");
				System.out.println("4.fund transfer");
				System.out.println("5.print transaction");
				System.out.println("enter your choice");
			}
			else {
				System.out.println("Enter valid details");
			}
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				
				System.out.println(service.showBalance());
				break;
			case 2:
				System.out.println("Enter the amount to be deposited");
				double dep_amount = sc.nextDouble();
				System.out.println(dep_amount);
				service.deposit(dep_amount);
				break;
			case 3:
				System.out.println("Enter the amount to be withdrawn");
				double withdraw_amount = sc.nextDouble();
				service.withdraw(withdraw_amount);
				break;
			case 4:
				System.out.println("Enter the account Number");
				long accNo = sc.nextLong();
				System.out.println("Enter the amount to transfer");
				double tran_amount = sc.nextDouble();
				service.fundTransfer(accNo, tran_amount);
				break;
			case 5:
				
				service.printTransaction();
				
				
			}
			}while(ch != 5);
		    
				

			
		}
		
		public static void main(String[] args) {
			int choice = 0;
			do {
				Scanner sc = new Scanner(System.in);
				System.out.println("****Welcome to Payment Wallet Application****");
				System.out.println("Enter your choice");
				System.out.println("1.create account");
				System.out.println("2.login");
				System.out.println("3.logout");
				System.out.println("--------------------------------");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
				    create();
					break;
				case 2:
					signin();
					break;
				case 3:
					System.out.println("Logged out succesfully");
					System.out.println("Thank you");
					System.exit(0);
					break;
					
				
				}
				
				
			}while(choice !=3);
		
		}
		
}
	



