package com.capg.WalletApp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.capg.WalletApp.bean.Customer;
import com.capg.WalletApp.util.DBUtil;

public class WalletApplicationDao implements IWalletApplicationDao{
	Connection con;
	public static ResultSet rs1;
	public static ResultSet rs2;
	public static ResultSet rs3;
	public static ResultSet rs4;
	double bal;
    public static long aadhar;
    public static long accNum;
	

	public int createAccount(Customer customer) {

		int n1 = 0;
		int n2 = 0;
		try {
			con = DBUtil.getConnection();
			
			
			String insertQuery1 = "insert into customer values(?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pstmt1 = con.prepareStatement(insertQuery1);
			
			System.out.println(customer.getFirstName());
			pstmt1.setString(1, customer.getFirstName());
			pstmt1.setLong(2, customer.getAadharNo());
			System.out.println(customer.getAadharNo());
			pstmt1.setString(3, customer.getContact());
			pstmt1.setString(4, customer.getGender());
			pstmt1.setString(5, customer.getEmail());
			pstmt1.setInt(6, customer.getAge());
			pstmt1.setString(7, customer.getUserName());
			pstmt1.setString(8, customer.getPassword());
			
			String insertQuery2 = "insert into wallet values(?,?,?,?,?,curdate())";
			java.sql.PreparedStatement pstmt2 = con.prepareStatement(insertQuery2);
			
			pstmt2.setLong(1, customer.getWallet().getAccNo());
			pstmt2.setDouble(2, customer.getWallet().getAmount());
			pstmt2.setLong(3, customer.getWallet().getAadhar_no());
			pstmt2.setString(4, customer.getWallet().getBranch());
			pstmt2.setString(5, customer.getWallet().getAccount_type());
			
			
			n1= pstmt1.executeUpdate();
			n2 = pstmt2.executeUpdate();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(n1==1 && n2 == 1) {
			return 1;
		}
		
		
		return 0;
	}

	public boolean login(String username, String password) {
		try {
			con = DBUtil.getConnection();
			java.sql.Statement stmt1 = con.createStatement();
			String selectQuery1 = "select * from customer where USER_ID='"+username+"' and password ='"+password+"'";
			rs1 = stmt1.executeQuery(selectQuery1);
			
			if(rs1.first()) {
				aadhar = rs1.getLong(2);
				java.sql.Statement stmt2 = con.createStatement();
				String selectQuery2 = "select * from wallet where AADHAR_NO="+aadhar;
				rs2=stmt2.executeQuery(selectQuery2);
				
				return true;
				
			}
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public double showBalance() {
		try {
			
			if(rs2.first()) {
				bal = rs2.getDouble(2);
				return bal;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bal;
	}

	public int deposit(double amount) {
		try {
			if(rs2.first()) {
				
				bal = rs2.getDouble(2) + amount;
				String updateQuery = "update wallet set INITIAL_BALANCE="+bal+"where AADHAR_NO="+rs2.getLong(3);
				System.out.println(updateQuery);
				java.sql.PreparedStatement stmt = con.prepareStatement(updateQuery);
				int r = stmt.executeUpdate();
				String selectQuery3 = "select * from wallet where AADHAR_NO="+rs2.getLong(3);
				java.sql.PreparedStatement stmt1 = con.prepareStatement(selectQuery3);
				
				System.out.println(r);
				rs2=stmt1.executeQuery();
				
				if(r==1) {
					System.out.println("Hii");
					String transaction = "Deposited "+Double.toString(amount);
					String insertQ = "insert into transaction values("+rs1.getLong(3)+",'"+transaction+"')";
					java.sql.PreparedStatement stmt2 = con.prepareStatement(insertQ);
					stmt2.executeUpdate();
					return 1;
				}
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return 0;
	}

	public int withdraw(double amount) {
		try {
			if(rs2.first()) {
				System.out.println(1);
				bal = rs2.getDouble(2) - amount;
				String updateQuery = "update wallet set INITIAL_BALANCE="+bal+"where AADHAR_NO="+rs2.getLong(3);
				System.out.println(updateQuery);
				String selectQuery3 = "select * from wallet where AADHAR_NO="+rs2.getLong(3);
				java.sql.PreparedStatement stmt = con.prepareStatement(updateQuery);
				int r = stmt.executeUpdate();
			    System.out.println(r);
				rs2=stmt.executeQuery(selectQuery3);
				if(r==1) {
					String transaction = "withdrawn "+Double.toString(amount);
					String insertQ = "insert into transaction values("+rs1.getLong(3)+",'"+transaction+"')";
					java.sql.PreparedStatement stmt2 = con.prepareStatement(insertQ);
					stmt2.executeUpdate();
					return 1;
				}

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int fundTransfer(long accNo, double amount) {
		int r = 0, r1 = 0;
		try {
			System.out.println(rs2.first());
	        if(rs2.first()) {
	        	String select = "select * from wallet where ACCOUNT_NO="+accNo;
			    java.sql.PreparedStatement stmt = con.prepareStatement(select);
		        rs3 = stmt.executeQuery();
	      
	        if(rs3.first()) {
	        	bal = rs3.getDouble(2)+amount;
	        	String update1 = "update wallet set INITIAL_BALANCE="+bal+"where AADHAR_NO="+rs3.getLong(3);
	        	System.out.println(update1);
	        	System.out.println("amount "+amount+" is credited to "+rs3.getLong(1));
	        	String trans1 = "amount "+amount+" is credited to "+rs3.getLong(1);
	        	String insertQ = "insert into transaction values("+rs1.getLong(3)+",'"+trans1+"')";
				java.sql.PreparedStatement stmttrans1 = con.prepareStatement(insertQ);
				stmttrans1.executeUpdate();
	        	
	        	java.sql.PreparedStatement stmt1 = con.prepareStatement(update1);
	        	r1 = stmt1.executeUpdate();
	        	
	        	double bal1 = rs2.getDouble(2) - amount;
	        	String update = "update wallet set INITIAL_BALANCE="+bal+"where AADHAR_NO="+rs2.getLong(3);
	        	java.sql.PreparedStatement stmt2 = con.prepareStatement(update);
	        	System.out.println("amount "+amount+" is debited to "+rs2.getLong(1));
	        	String trans2 = "amount "+amount+" is debited to "+rs2.getLong(1);
	        	String insertQ1 = "insert into transaction values("+rs1.getLong(3)+",'"+trans2+"')";
				java.sql.PreparedStatement stmttrans2 = con.prepareStatement(insertQ1);
				stmttrans2.executeUpdate();
	        	
	        	r = stmt1.executeUpdate();
	        	if(stmt1.executeUpdate()==1) {
	        		long k = rs1.getLong(2);
	        		String select1 = "select * from wallet where AADHAR_NO="+k;
	        		java.sql.PreparedStatement stmt3 = con.prepareStatement(select1);
	        		rs2 = stmt3.executeQuery();
	        		
	        	}
	        	
	        }
	        }
	        if(r1 == 1 && r == 1) {
	        	return 1;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void printTransaction() {
		try {
			String select = "select * from transaction where aadharNo ="+rs1.getLong(3);
			java.sql.PreparedStatement stmt = con.prepareStatement(select);
			rs4 = stmt.executeQuery();
			while(rs4.next()) {
				System.out.println(rs4.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	

}
