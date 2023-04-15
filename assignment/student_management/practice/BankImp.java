package com.assignment.student_management.practice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.nextstep.studentmanagementsystem.practic.DataBaseConnection;
import com.nextstep.studentmanagementsystem.practic.StudentDTO;

public class BankImp implements Bank {
	PreparedStatement ps=null;
	private String name;
    private long accountNum;
    JTextField nametextField;
    JTextField  accountNumtextField_1;
  
	public void saveBankData(BankDTO objDTO) {
	String sql="insert into bank(name,address,gender,contact,accounttype,accountnum,amount)values(?,?,?,?,?,?,?)";
		try {
		ps=DataConnection.getConnection().prepareStatement(sql);
		ps.setString(1,objDTO.getName());
		ps.setString(2,objDTO.getAddress());
		ps.setString(3,objDTO.getGender());
		ps.setLong(4,objDTO.getContactNumber());
		ps.setString(5,objDTO.getAccounttype());
		ps.setLong(6,objDTO.getAccountnum());
		ps.setDouble(7,objDTO.getAmount());
		ps.executeUpdate();
		
	}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
	@Override
	public ArrayList<BankDTO> getBankDetail() {//to get obj call through classname
		String sql=("select * from bank");
		ArrayList<BankDTO>bankList=new ArrayList<>();
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BankDTO obj=new BankDTO();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setAddress(rs.getString("address"));
				obj.setContactNumber(rs.getLong("contact"));
				obj.setGender(rs.getString("gender"));
				obj.setAccounttype(rs.getString("accounttype"));
				obj.setAccountnum(rs.getLong("accountnum"));
				obj.setAmount(rs.getLong("amount"));
				bankList.add(obj);
				}
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
			return bankList;
		
	}
	@Override
	public ArrayList<BankDTO> searchStudentData(String name) {
		String sql="select * from bank where name like ?";
		ArrayList<BankDTO>bankList=new ArrayList<>();
		try {
		ps=DataConnection.getConnection().prepareStatement(sql);
		ps.setString(1,"%"+name+"%");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			BankDTO obj=new BankDTO();
			obj.setId(rs.getInt("id"));
			obj.setName(rs.getString("name"));
			obj.setAddress(rs.getString("address"));
			obj.setContactNumber(rs.getLong("contact"));
			obj.setGender(rs.getString("gender"));
			obj.setAccounttype(rs.getString("accounttype"));
			obj.setAccountnum(rs.getLong("accountnum"));
			obj.setAmount(rs.getLong("amount"));
			bankList.add(obj);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return bankList;
	}
	@Override
	public void deleteBankData(int id) {
		String sql="Delete from bank where id=?";
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} 
		 catch (Exception e) {
			 System.out.println(e);
		}
		
	}
	@Override
	public void editBankData(BankDTO objDTO) {
		String sql="update bank set name=?,address=?,contact=?,gender=?,accounttype=?,accountnum=?,amount=? where id=?";
		try {
			ps=DataBaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, objDTO.getName());
			ps.setString(2, objDTO.getAddress());
			ps.setLong(3, objDTO.getContactNumber());
			ps.setString(4, objDTO.getGender());
			ps.setString(5, objDTO.getAccounttype());
			ps.setLong(6, objDTO.getAccountnum());
			ps.setDouble(7, objDTO.getAmount());
			ps.setInt(8, objDTO.getId());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	@Override
	public long getGreatestAccountNumber() {
		long accountNumber=0;
		String sql="SELECT max(accountnum) accountnum from bank";
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				accountNumber=rs.getLong("accountnum");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("highest account number is "+ accountNumber);
		return accountNumber;
	}
	/*
	public boolean depositeAmount(BankDesposit bankDesposit) {
		boolean success=false;
		String sql="update bank set amount=? where accountNumber=?";
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ps.setDouble(1, bankDesposit.getBalance());
			ps.setLong(2, bankDesposit.getAccountNumber());
			ps.executeUpdate();
			success=true;
		} catch (Exception e) {
			success=false;			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
		
		
	}
	*/
	@Override
	public boolean increaseBalance(long accountnum, double amount) {
	    String selectSql = "SELECT amount FROM bank WHERE accountnum = ?";
	    String updateSql = "UPDATE bank SET amount = ? WHERE accountnum = ?";
	    boolean success = false;
	    try {
	        // Retrieve the current balance of the user
	        PreparedStatement selectPs = DataConnection.getConnection().prepareStatement(selectSql);
	        selectPs.setLong(1, accountnum);
	        ResultSet selectRs = selectPs.executeQuery();
	        if (selectRs.next()) {
	            double currentBalance = selectRs.getDouble("amount");
	            // Add the desired amount to the balance
	            double newBalance = currentBalance + amount;
	            // Update the balance in the database
	            PreparedStatement updatePs = DataConnection.getConnection().prepareStatement(updateSql);
	            updatePs.setDouble(1, newBalance);
	            updatePs.setLong(2, accountnum);
	            int rowsUpdated = updatePs.executeUpdate();
	            if (rowsUpdated > 0) {
	                success = true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}
	@Override
	public boolean login(String name,long accountNum) {
	    boolean isUserExist=false;
	    String sql = "SELECT * FROM bank WHERE name=? AND accountnum=?";
	    try {
	        PreparedStatement ps = DataConnection.getConnection().prepareStatement(sql);
	        ps.setString(1, name);
	        ps.setLong(2, accountNum);
	        ResultSet rs = ps.executeQuery();
	       while(rs.next()) {
	    	   isUserExist=true;
	    	   
	       }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return isUserExist;
	}
	@Override
	public BankDTO getCustomerDetail(long accountNum) {
		String sql="select *from bank where accountnum=?";
		BankDTO studentobj=new BankDTO();
		
		try {
			ps=DataConnection.getConnection().prepareStatement(sql);
			ps.setLong(1, accountNum);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				studentobj.setId(rs.getInt("id"));
				studentobj.setName(rs.getString("name"));
				studentobj.setAddress(rs.getString("address"));
				studentobj.setGender(rs.getString("gender"));
				studentobj.setContactNumber(rs.getLong("contact"));
				studentobj.setAccounttype(rs.getString("accounttype"));
				studentobj.setAccountnum(rs.getLong("accountnum"));
				studentobj.setAmount(rs.getDouble("amount"));
				
			}
		} 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return studentobj;
	}
	@Override
	public boolean decreaseBalance(long accountnum, double amount,String name) {
		String selectSql = "SELECT amount FROM bank WHERE accountnum = ?";
	    String updateSql = "UPDATE bank SET amount = ? WHERE accountnum = ?";
	    boolean success = false;
	    try {
	        // Retrieve the current balance of the user
	        PreparedStatement selectPs = DataConnection.getConnection().prepareStatement(selectSql);
	        selectPs.setLong(1, accountnum);
	        ResultSet selectRs = selectPs.executeQuery();
	        if (selectRs.next()) {
	            double currentBalance = selectRs.getDouble("amount");
	            // Add the desired amount to the balance
	            double newBalance = currentBalance - amount;
	            // Update the balance in the database
	            PreparedStatement updatePs = DataConnection.getConnection().prepareStatement(updateSql);
	            updatePs.setDouble(1, newBalance);
	            updatePs.setLong(2, accountnum);
	            int rowsUpdated = updatePs.executeUpdate();
	            if (rowsUpdated > 0) {
	                success = true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}
		
	}
	
	
	
	
	


			
			
			
		


	



		

	
		
	
	

	
		
	
	