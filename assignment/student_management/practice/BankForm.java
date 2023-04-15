package com.assignment.student_management.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.nextstep.studentmanagementsystem.practic.Student;
import com.nextstep.studentmanagementsystem.practic.StudentDTO;
import com.nextstep.studentmanagementsystem.practic.StudentDetails;
import com.nextstep.studentmanagementsystem.practic.StudentImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BankForm extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;
	JComboBox box;
	private JTextField contacttextField_1;
	private JTextField addresstextField_2;
	private JTextField accountNumtextField;
	Bank bank= new BankImp();
	private JTextField amounttextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankForm frame = new BankForm();
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
	public BankForm() {
		long accountNumber=bank.getGreatestAccountNumber();
		String currentAccountNumber=String.valueOf(accountNumber+1);
		
		setResizable(false);
		setTitle("BankSystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(24, 28, 70, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContact.setBounds(24, 145, 70, 28);
		contentPane.add(lblContact);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(24, 67, 70, 28);
		contentPane.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(24, 106, 70, 28);
		contentPane.add(lblGender);
		
		nametextField = new JTextField();
		nametextField.setBounds(227, 28, 148, 27);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		contacttextField_1 = new JTextField();
		contacttextField_1.setColumns(10);
		contacttextField_1.setBounds(227, 145, 148, 27);
		contentPane.add(contacttextField_1);
		
		addresstextField_2 = new JTextField();
		addresstextField_2.setColumns(10);
		addresstextField_2.setBounds(227, 67, 148, 27);
		contentPane.add(addresstextField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male", "Other"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(227, 106, 148, 28);
		contentPane.add(comboBox);
		
		
		JButton submitbtnNewButton = new JButton("Submit");
		submitbtnNewButton.setBackground(Color.GREEN);
		submitbtnNewButton.setForeground(Color.BLACK);
		submitbtnNewButton.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				String name=nametextField.getText();
				String address=addresstextField_2.getText();
				String gender=(String)comboBox.getSelectedItem();
				long contact=Long.parseLong(contacttextField_1.getText());
				String accounttype= (String) box.getSelectedItem();
				long accountnumber=Long.parseLong(accountNumtextField.getText());
			     long amount=Long.parseLong(amounttextField.getText());
				BankDTO obj=new BankDTO();
				obj.setName(name);
				obj.setAddress(address);
				obj.setContactNumber(contact);
				obj.setGender(gender);
				obj.setAccounttype(accounttype);
				obj.setAccountnum(accountnumber);
				obj.setAmount(amount);
				 Bank bank=new BankImp();
				bank.saveBankData(obj);//function..which is static so call by using callname
				dispose();
				new BankDetails().setVisible(true);
			
			}
		});
				
				
				
				
		
		submitbtnNewButton.setBounds(247, 334, 89, 35);
		contentPane.add(submitbtnNewButton);
		
		JLabel lblAccounttype = new JLabel("AccountType");
		lblAccounttype.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccounttype.setBounds(24, 184, 107, 28);
		contentPane.add(lblAccounttype);
		
		JLabel lblContact_1_1 = new JLabel("AccountNum");
		lblContact_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContact_1_1.setBounds(24, 238, 107, 28);
		contentPane.add(lblContact_1_1);
		
		 box = new JComboBox();
		box.setModel(new DefaultComboBoxModel(new String[] {"Saving", "Fixed", "Current"}));
		box.setBounds(227, 191, 148, 28);
		contentPane.add(box);
		
		accountNumtextField = new JTextField();
		accountNumtextField.setEditable(false);
		accountNumtextField.setBounds(227, 238, 148, 27);
		contentPane.add(accountNumtextField);
		accountNumtextField.setColumns(10);
		accountNumtextField.setText(currentAccountNumber);
		
		JButton btnNewButton = new JButton("Cancle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BankDetails().setVisible(true);	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(364, 337, 89, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblAmount = new JLabel("amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAmount.setBounds(24, 277, 107, 28);
		contentPane.add(lblAmount);
		
		amounttextField = new JTextField();
		amounttextField.setColumns(10);
		amounttextField.setBounds(227, 284, 148, 27);
		contentPane.add(amounttextField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\Camera Roll\\93-938757_75-web-website-background-color.jpg"));
		lblNewLabel_1.setBounds(0, 11, 483, 369);
		contentPane.add(lblNewLabel_1);
	}
}
