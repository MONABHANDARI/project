package com.assignment.student_management.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.nextstep.studentmanagementsystem.practic.Student;
import com.nextstep.studentmanagementsystem.practic.StudentDTO;
import com.nextstep.studentmanagementsystem.practic.StudentDetails;
import com.nextstep.studentmanagementsystem.practic.StudentForm;
import com.nextstep.studentmanagementsystem.practic.StudentImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BankDetails extends JFrame {

	protected static final String DefaultTableModel = null;
	private JPanel contentPane;
	private JTextField searchtextField;
	private JTable table;
	Bank obj=new BankImp();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankDetails frame = new BankDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankDetails() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(255, 11, 90, 31);
		contentPane.add(lblNewLabel);
		
		searchtextField = new JTextField();
		searchtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String name=searchtextField.getText();
				if(name==null ||name.isEmpty()) {
					loadDataOfDB();
					
				}
				else {
					searchStudentData(name);
				}
				
			}
		});
		searchtextField.setBounds(355, 11, 153, 25);
		contentPane.add(searchtextField);
		searchtextField.setColumns(10);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BankForm().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(20, 322, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
			 
			 
			
		
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEdit.setBounds(136, 322, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
				int row=table.getSelectedRow();
				Object id =tableModel.getValueAt(row, 0);
			int status=JOptionPane.showConfirmDialog(BankDetails.this, "Do you really want to delete","Delete",JOptionPane.YES_NO_OPTION);
			if(status==0) {
				Bank bankObj=new BankImp();
			bankObj.deleteBankData(Integer.parseInt(id.toString()));	
			loadDataOfDB();
			}
			}
		
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(269, 322, 89, 23);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(10, 53, 624, 258);
		contentPane.add(table);
		String [] columnName= {"id","name","address","gender","contact","accounttype","accountnum","amount"};
	     DefaultTableModel obj1=new DefaultTableModel(columnName,0);
	     table.setModel(obj1);
	     loadDataOfDB();
	     JScrollPane abc=new JScrollPane(table);//used to display a table within a limited viewable area
	     abc.setBounds(10, 53, 701, 258);
	     contentPane.add(abc);
	     
	     JButton btnNewButton_1 = new JButton("Deposit");
	     btnNewButton_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
				int row=table.getSelectedRow();
				Object accountNumber =tableModel.getValueAt(row, 6);
				CustomerDetail customerDetails= new CustomerDetail();
				customerDetails.accountNumberTextField.setText(accountNumber.toString());
	     		dispose();
	     		customerDetails.setVisible(true);
	     	}
	     });
	     btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	     btnNewButton_1.setBounds(390, 323, 108, 22);
	     contentPane.add(btnNewButton_1);
	     
	     JButton btnNewButton_2 = new JButton("cancel");
	     btnNewButton_2.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		dispose();
	     		new Combined().setVisible(true);
	     	}
	     });
	     btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	     btnNewButton_2.setBounds(642, 322, 89, 23);
	     contentPane.add(btnNewButton_2);
	     
	     JButton btnNewButton_3 = new JButton("WithDraw");
	     btnNewButton_3.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
				int row=table.getSelectedRow();
				Object accountNumber =tableModel.getValueAt(row, 6);
				Object name =tableModel.getValueAt(row, 1);
				WithDraw withdrawDetails= new WithDraw();
				withdrawDetails.accountNumtextField.setText(accountNumber.toString());
				withdrawDetails.nametextField_1.setText(name.toString());
				dispose();
	     		withdrawDetails.setVisible(true);	
	     		
	     		
	     	}
	     });
	     btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
	     btnNewButton_3.setBounds(508, 325, 124, 23);
	     contentPane.add(btnNewButton_3);
	}
	public void loadDataOfDB() {
		//(obj)is reference variable,imp is child class
		ArrayList<BankDTO>bankList=obj.getBankDetail();// "obj" is an instance of a class that has a method called "getBankDetail()"
		DefaultTableModel obj1=(DefaultTableModel) table.getModel();
		obj1.setRowCount(0);
	for(BankDTO bankObj:bankList) {//(string name:arrayList)foreach loop
		obj1.addRow(new Object[] { //it  create a new row    
				bankObj.getId(),
				bankObj.getName(),
				bankObj.getAddress(),
				bankObj.getGender(),
				bankObj.getContactNumber(),
				bankObj.getAccounttype(),
				bankObj.getAccountnum(),
				bankObj.getAmount()
				
				
				
		});
	}
	}
	
	public void searchStudentData(String name) {  
		
		ArrayList<BankDTO>bankList=obj.searchStudentData(name);
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
	for(BankDTO bankDTO:bankList) {
		tableModel.addRow(new Object[] {     
				bankDTO.getId(),
				bankDTO.getName(),
				bankDTO.getAddress(),
				bankDTO.getGender(),
				bankDTO.getContactNumber(),
				bankDTO.getAccounttype(),
				bankDTO.getAccountnum(),
				bankDTO.getAmount()
	});
		
	}
	
	}
}
