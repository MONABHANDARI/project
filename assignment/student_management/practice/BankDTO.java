package com.assignment.student_management.practice;

public class BankDTO {
	private int id;
	private	String name,address,gender,accounttype;
	private	long ContactNumber,accountnum;
	private double amount;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public long getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(long contactNumber) {
		ContactNumber = contactNumber;
	}
	public long getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(long accountnum) {
		this.accountnum = accountnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}