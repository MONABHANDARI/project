package com.assignment.student_management.practice;

import java.util.ArrayList;

import com.nextstep.studentmanagementsystem.practic.StudentDTO;

public interface Bank {
	public void saveBankData(BankDTO objDTO);
	public ArrayList<BankDTO> getBankDetail();
	public ArrayList<BankDTO>searchStudentData(String name);
	public void deleteBankData(int id);
	public void editBankData(BankDTO objDTO);
	public long getGreatestAccountNumber();
	//public boolean depositeAmount(BankDesposit bankDesposit);
	public boolean increaseBalance(long accountnum,double amount);
	public boolean login(String name,long accountNum);
	public BankDTO getCustomerDetail(long accountNum); 
	public boolean decreaseBalance(long accountnum,double amount,String name);
}
